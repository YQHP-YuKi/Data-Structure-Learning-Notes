package sort;

/**
 * @author YQHP-YuKi
 * @create 2021-03-27 11:39
 */
public class Insertion {

  public static void sort(Comparable[] a) {
    //从第一个开始,挨个开始插入排序到最后
    for (int i = 1; i <= a.length - 1; i++) {
      //以倒序的方式进行向前查找
      for (int j = i; j > 0; j--) {
        //如果前面比后面大,就交换元素i与j,如果前面比后面小,则直接跳出此层循环,继续向后进行排序
        if (greater(a[j - 1], a[j])) {
          exch(a, j - 1, j);
        } else {
          break;
        }
      }
    }
  }


  /**
   * 创建比较元素的方法
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
