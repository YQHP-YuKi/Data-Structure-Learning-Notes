package sort;

import java.util.Arrays;

/**
 * @author YQHP-YuKi
 * @create 2021-03-18 17:23
 */
public class ShellTest {

  public static void main(String[] args) {
    Integer[] arr = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
    Shell.sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public void show() {
    System.out.println("test");
    show();
  }
}

