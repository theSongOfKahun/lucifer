package cn.kahun.common.test.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import org.junit.Test;

/**
 * @create: 2019/12/18 2:59 下午
 * @author: liboah
 * @description:
 **/
public class SimpleTest {

  private static final String FILE_PATH = "/Users/prague/Pictures/test/11.jpeg";

  @Test
  public void testFileSize() throws IOException {

    System.out.println(5.1 * 1024 * 1024);

    File file = new File(FILE_PATH);

    System.out.println(file.length());

    byte[] content = Files.readAllBytes(Paths.get(FILE_PATH));

    System.out.println(content.length);

    String fileContent = Base64.getEncoder().encodeToString(content);

    System.out.println(fileContent.length());

  }

  @Test
  public void testBase64(){



  }

}
