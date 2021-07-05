package sort;

import java.lang.reflect.WildcardType;
import java.util.stream.StreamSupport;

/**
 * @author YQHP-YuKi
 * @create 2021-03-30 17:03
 */
public class Merge {

  /**
   * 归并所需要的辅助数组
   */
  private static Comparable[] assist;

  /**
   * 比较v元素是否小于w元素
   */
  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  /**
   * 对数组a中的元素进行排序
   */
  public static void sort(Comparable[] a) {
    //1.初始化辅助数组assist
    assist = new Comparable[a.length];
    //2.定义一个lo变量和hi变量,分别记录数组中最小的索引位置和最大的索引位置
    int lo = 0;
    int hi = a.length - 1;
    //3.调用sort的重载方法完成数组a中,从索引lo到索引hi的元素的排序
    sort(a, lo, hi);
  }

  /**
   * 对数组a中从lo到hi的元素进行排序
   */
  private static void sort(Comparable[] a, int lo, int hi) {
    //做安全性校验
    if (hi <= lo) {
      return;
    }
    //对从lo到hi之间的数据进行分组,分为两组
    int mid = lo + (hi - lo) / 2;
    //分别对每一组进行排序
    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    //再将两个组的数据合在一起,进行归并
    merge(a, lo, mid, hi);
  }

  /**
   * 对数组中,从lo到mid为一组,从mid+1到hi为一组,对这两组数据进行归并
   */
  private static void merge(Comparable[] a, int lo, int mid, int hi) {
    //定义三个指针,一个指向数组头lo作为归并辅助数组assist的头,一个指向待归并数组的头作为左数组的头,一个作为待归并右数组的头
    int i = lo;
    int p1 = lo;
    int p2 = mid + 1;
    //遍历左右两个数组,移动p1与p2两个指针,将数字较小的元素放入到辅助数组assist中
    while (p1 <= mid && p2 <= hi) {
      //比较对应元素的值
      if (less(a[p1], a[p2])) {
        assist[i++] = a[p1++];
      } else {
        assist[i++] = a[p2++];
      }
    }
    //当左数组遍历完或者右数组遍历完,就将剩下的一遍数组的剩余元素全部移动到辅助数组上去
    while (p1 <= mid) {
      assist[i++] = a[p1++];
    }
    while (p2 <= hi) {
      assist[i++] = a[p2++];
    }
    //全部归并且排好序了,将辅助数组复制到原数组当中
    for (int index = lo; index <= hi; index++) {
      a[index] = assist[index];
    }
  }
}
