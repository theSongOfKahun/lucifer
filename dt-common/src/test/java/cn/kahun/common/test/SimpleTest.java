package cn.kahun.common.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
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

  @Test
  public void testTrouble(){

    JSONObject jsonObject = JSONObject.parseObject(bill);

    JSONArray jsonArray = jsonObject.getJSONArray("bills");

    List<String> list = new ArrayList<>(jsonArray.size());

    for (int i = 0; i < jsonArray.size(); i++) {

      JSONObject detail = jsonArray.getJSONObject(i);

      list.add(detail.getString(""));

    }

    List<String> list2 = Arrays.asList(hm.split(","));

    list.removeAll(list2);

    System.out.println(JSON.toJSONString(list));



  }

  private static String hm = "02828578,08050825,17970606,18149392,18607171,18732587,18868769,19120285,19120329,19120733,19120750,19351643,22636948,24861289,25924856,25925034,36033990,36097460,37340557,37520532,38134881,38134901,38176845,41388720,60467566,60572291,61475556,70543348,70543607,72806342,72866490,72866703,73707456,75483733,78166762,78167134,78349875,78349948,78518156,83877370,83877416,92919160,93156777,93156810,97102348,97102364";

  private static String bill = "{\n"
      + "\t\"bills\": [{\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"18149392\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"17970606\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"02828578\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"72866703\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"032001700112\",\n"
      + "\t\t\"invoiceNum\": \"41388720\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"18732587\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"18607171\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"61475556\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"031001800112\",\n"
      + "\t\t\"invoiceNum\": \"70543607\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"78349948\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"60572291\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"031001700112\",\n"
      + "\t\t\"invoiceNum\": \"37340557\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"031001700112\",\n"
      + "\t\t\"invoiceNum\": \"60467566\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"93156810\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"73707456\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"78167134\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"72806342\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"72866490\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"93156777\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"97102348\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"36033990\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"08050825\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"78518156\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"78349875\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"25924856\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"78166762\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"22636948\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"38176845\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"032001700112\",\n"
      + "\t\t\"invoiceNum\": \"24861289\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"031001700112\",\n"
      + "\t\t\"invoiceNum\": \"37520532\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"92919160\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"38134901\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"031001800112\",\n"
      + "\t\t\"invoiceNum\": \"70543348\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"19120329\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"38134881\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"032001700112\",\n"
      + "\t\t\"invoiceNum\": \"75483733\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"83877416\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"97102364\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"36097460\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"19120733\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"25925034\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"19120750\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"83877370\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"19120285\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001900112\",\n"
      + "\t\t\"invoiceNum\": \"19351643\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}, {\n"
      + "\t\t\"billType\": \"invoice\",\n"
      + "\t\t\"invoiceCode\": \"033001800112\",\n"
      + "\t\t\"invoiceNum\": \"18868769\",\n"
      + "\t\t\"reimburseUser\": \"0001A1100000000AE1XV\"\n"
      + "\t}],\n"
      + "\t\"nsrsbh\": \"91330106MA28M65R7X\",\n"
      + "\t\"orgcode\": \"63010\"\n"
      + "}";

}
