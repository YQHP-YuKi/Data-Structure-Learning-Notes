package sort;

import java.util.Arrays;

/**
 * @author YQHP-YuKi
 * @create 2021-03-18 16:56
 */

public class Shell {

  public static void sort(Comparable[] a) {
    //首先由数组的长度来确定增长量h
    int h = 1;
    while (h < a.length / 2) {
      h = h * 2 + 1;
    }
    //进行希尔排序
    while (h >= 1) {
      /**
       * 其实我们分组,就是按0号位作为第一组元素的第一个默认排号的元素进行排序的
       * 而一共有h的间距,所以第一组第一个是0,第二组第一个是0+1,....第h组第一个是0+h*/
      for (int i = h; i <= a.length - 1; i++) {
        /**
         * 还是老样子,从后往前进行比较,只不过查看的间距不再是插入排序的1,而是h*/
        for (int j = i; j >= h; j -= h) {
          if (greater(a[j - h], a[j])) {
            exch(a, j - h, j);
          } else {
            break;
          }
        }
      }
      //更新h的值
      h = h / 2;
    }
  }


  /**
   * 比较v与w的值
   */
  private static boolean greater(Comparable v, Comparable w) {
    return v.compareTo(w) > 0;
  }


  /**
   * 创建交换元素i与j的值方法
   */
  private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }
}
