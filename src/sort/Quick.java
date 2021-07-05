package sort;

/**
 * @author YQHP-YuKi
 * @create 2021-04-04 9:29
 */
public class Quick {

  /**
   * 比较v元素是否小于w元素
   */
  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  /**
   * 数组元素i和j交换位置
   */
  private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  /**
   * 对数组内的元素进行排序
   */
  public static void sort(Comparable[] a) {
    int lo = 0;
    int hi = a.length - 1;
    sort(a, lo, hi);
  }

  /**
   * 对数组a中从索引lo到索引hi之间的元素进行排序
   */
  private static void sort(Comparable[] a, int lo, int hi) {
    //安全性校验
    if (hi <= lo) {
      return;
    }
    //需要对数组中lo索引到hi索引处的元素进行分组(左子组和右子组)
    //返回的是分组的分界值所在的索引,是分界值位置变换后的索引
    int partition = partition(a, lo, hi);
    //让左子组有序,因为partition是分界值,不需要排序,所以是partition-1
    sort(a, lo, partition - 1);
    //让右子组有序,因为partition是分界值,不需要排序,所以是partition+1
    sort(a, partition + 1, hi);
  }

  /**
   * 对数组a中,从索引lo到索引hi之间的元素进行分组,并返回分组界限对应的索引
   */
  public static int partition(Comparable[] a, int lo, int hi) {
    //确定分界值
    Comparable key = a[lo];
    //定义两个指针,分别指向待切分元素的最小索引处与最大索引处的下一位置
    int left = lo;
    int right = hi + 1;
    //切分
    while (true) {
      //先从右往左扫描,移动right指针,找到一个比分界值小的元素,并停止
      while (less(key, a[--right])) {
        if (right == lo) {
          break;
        }
      }
      //再从左往右扫描,移动left指针,找到一个比分界值大的元素，并停止
      while (less(a[++left], key)) {
        if (left == hi) {
          break;
        }
      }
      //判断left>=right,如果是则证明元素全部扫描完毕,结束循环,如果不是,继续扫描
      if (left >= right) {
        break;
      } else {
        exch(a, left, right);
      }
    }
    //这里主要要写right,因为left可能还会向右移动一格,所以就形成了left>right,所以真正的中间位置是right,而不是left
    exch(a, lo, right);
    return right;
  }
}
