package sort;

import java.util.Arrays;

/**
 * @author YQHP-YuKi
 * @create 2021-04-02 10:37
 */
public class MergeTest {

  public static void main(String[] args) {
    Integer[] a = {8, 4, 5, 7, 1, 3, 6, 2};
    Merge.sort(a);
    System.out.println(Arrays.toString(a));
  }
}
