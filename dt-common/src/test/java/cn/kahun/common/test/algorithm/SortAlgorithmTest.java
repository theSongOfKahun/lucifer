package cn.kahun.common.test.algorithm;

import cn.kahun.common.algorithm.SortingAlgorithm;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;

/**
 * @author libo
 * @date 2020/2/10 0:40
 * @description 记得写注释
 */
public class SortAlgorithmTest {

  public void testInsertionSort(){

    int[] array = random(20);

    SortingAlgorithm.insertionSort(array);

    System.out.println(StringUtils.join(array,','));

  }



  private int[] generateRandomArray(int length){

    int[] array = new int[length];

    Random random = new Random();

    for (int i = 0; i < length; i++) {

      array[i] = random.nextInt();

    }

    return array;
  }

  private int[] random(int length){

    int[] array = new int[length];

    for (int i = 0; i < length; i++) {

      array[i] = (int) (Math.random() * 100);

    }

    return array;
  }

}
