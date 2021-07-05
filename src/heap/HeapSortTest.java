package heap;

import java.util.Arrays;

/**
 * @author YQHP-YuKi
 * @create 2021-06-16 22:31
 */
public class HeapSortTest {

  public static void main(String[] args) {
    //待排序数组
    String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
    //通过HeapSort对数组中的元素进行排序
    HeapSort.sort(arr);
    //输入排序后的数组元素
    System.out.println(Arrays.toString(arr));
  }
}
