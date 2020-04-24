package cn.kahun.sa.framework.spring.scanner;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

/**
 * @create: 2020/4/24 10:34 上午
 * @author: liboah
 * @description: 记得写注释。。。
 **/

@Service
public class ProbeClassPathBeanDefinitionScanner {

  static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";


  public Set<BeanDefinition> scanCandidateComponents(String basePackage) throws IOException {

    Set<BeanDefinition> beanDefinitionSet = new LinkedHashSet<>();

    String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
        ClassUtils.convertClassNameToResourcePath(new StandardEnvironment().resolveRequiredPlaceholders(basePackage)) + '/' + DEFAULT_RESOURCE_PATTERN;

    Resource[] resources = new PathMatchingResourcePatternResolver().getResources(packageSearchPath);

    TypeFilter annotationTypeFilter = new AnnotationTypeFilter(Component.class);

    MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();

    for (Resource resource:resources) {

      if (resource.isReadable()){

        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);

        if (annotationTypeFilter.match(metadataReader,metadataReaderFactory)){

          ScannedGenericBeanDefinition scannedGenericBeanDefinition =
              new ScannedGenericBeanDefinition(metadataReader);

          scannedGenericBeanDefinition.setResource(resource);
          scannedGenericBeanDefinition.setSource(resource);

          beanDefinitionSet.add(scannedGenericBeanDefinition);
        }

      }

    }

    return beanDefinitionSet;
  }

}
