package cn.kahun.sa.framework.spring.test.file;

import cn.kahun.sa.framework.spring.file.FileSystemStorageService;
import cn.kahun.sa.framework.spring.file.StorageProperties;
import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

/**
 * @create: 2020/4/10 4:58 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class UnitTest {

  private StorageProperties storageProperties = new StorageProperties();
  private FileSystemStorageService fileSystemStorageService;

  @BeforeEach
  public void init(){

    storageProperties.setLocation("target/files/"+Math.abs(new Random().nextLong()));
    fileSystemStorageService = new FileSystemStorageService(storageProperties);
    fileSystemStorageService.init();
  }

  @Test
  public void testLoadNotExist(){

    Assertions.assertThat(fileSystemStorageService.load("foo.txt")).doesNotExist();
  }

  @Test
  public void testSave(){

    fileSystemStorageService.store(new MockMultipartFile("foo","foo.txt", MediaType.TEXT_PLAIN_VALUE,"Hello World!".getBytes()));

  }


}
