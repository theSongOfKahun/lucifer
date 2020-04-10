package cn.kahun.common.algorithm;

/**
 * @author libo
 * @date 2020/2/10 0:22
 * @description 各种排序算法
 */
public class SortingAlgorithm {


  public static void insertionSort(int[] array){

    for (int i = 1; i < array.length; i++) {

      int temp = array[i];
      int index = 0;

      for (int j = i; j > 0 && temp < array[j-1]; j--) {

        array[j] = array[j-1];
        index = j-1;
      }

      array[index] = temp;

    }

  }


}
