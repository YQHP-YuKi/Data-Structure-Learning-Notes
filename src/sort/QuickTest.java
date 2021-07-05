package sort;

import java.util.Arrays;

/**
 * @author YQHP-YuKi
 * @create 2021-04-04 10:51
 */
public class QuickTest {

  public static void main(String[] args) {
    Integer[] a = {6, 1, 2, 7, 9, 3, 4, 5, 8};
    Quick.sort(a);
    System.out.println(Arrays.toString(a));
  }
}
