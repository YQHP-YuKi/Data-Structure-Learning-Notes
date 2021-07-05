package sort;

import java.util.Arrays;

/**
 * @author YQHP-YuKi
 * @create 2021-03-27 11:40
 */
public class InsertionTest {

  public static void main(String[] args) {
    Integer[] arr = {4, 3, 2, 10, 12, 1, 5, 6};
    Insertion.sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
