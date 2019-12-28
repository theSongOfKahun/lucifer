package cn.kahun.dt.cache.local.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Component;

/**
 * @create: 2019/12/18 11:09 上午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@Component
public class LoadingCacheComponent {

  private static final LoadingCache<String, AtomicInteger> count =
      CacheBuilder.newBuilder().initialCapacity(1).
      maximumSize(1).build(new CacheLoader<String, AtomicInteger>() {
        @Override
        public AtomicInteger load(String key) throws Exception {
          return new AtomicInteger(0);
        }
      });

  public static void main(String[] args) {

    AtomicInteger number = count.getUnchecked("wode");

    System.out.println(number);

    number.addAndGet(1);

    System.out.println(count.getUnchecked("wode"));

  }

}
