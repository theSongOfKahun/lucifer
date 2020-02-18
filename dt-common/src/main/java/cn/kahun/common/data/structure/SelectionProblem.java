package cn.kahun.common.data.structure;

import java.util.Random;

/**
 * @author libo
 * @date 2020/2/10 0:08
 * @description 选择问题
 */
public class SelectionProblem {

  public static int[] getRandomArray(int num){

    int[] randomArray = new int[num];

    Random random = new Random();

    for (int i = 0; i < num; i++) {

      randomArray[i] = random.nextInt();
    }

    return randomArray;
  }

  public static void main(String[] args) {

    Random random = new Random();

    System.out.println(random.nextInt());

  }

}
