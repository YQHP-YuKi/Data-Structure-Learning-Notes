package heap;


/**
 * @author YQHP-YuKi
 * @create 2021-06-16 16:55
 */
public class HeapSort {

  /**
   * 判断heap堆中索引i处的元素是否小于索引j处的元素
   */
  private static boolean less(Comparable[] heap, int i, int j) {
    return heap[i].compareTo(heap[j]) < 0;
  }

  /**
   * 交换heap堆中i索引和j索引处的值
   */
  private static void exch(Comparable[] heap, int i, int j) {
    Comparable tmp = heap[i];
    heap[i] = heap[j];
    heap[j] = tmp;
  }

  /**
   * 根据原数组source,构造出堆heap
   */
  private static void createHeap(Comparable[] source, Comparable[] heap) {
    //把source数组中的元素拷贝到heap数组中,此时的heap数组是个无序的堆,需要对其进行排序
    System.arraycopy(source, 0, heap, 1, source.length);
    //使用下沉调整,范围为(1~length/2),因为使用下沉排序,所以是要寻找2k的子节点,所以为了节省时间,从中间length/2开始找
    for (int i = (heap.length) / 2; i > 0; i--) {
      //从i开始,到堆的末尾结束,进行下沉
      sink(heap, i, heap.length - 1);
    }
  }

  /**
   * 对source数组中的数据从小到大进行排序
   */
  public static void sort(Comparable[] source) {
    //构建堆
    //之所以长度+1,那是因为原数组是0开始,堆是1开始,这时候的Heap就是无序的数组
    Comparable[] heap = new Comparable[source.length + 1];
    createHeap(source, heap);
    //定义一个变量,记录未排序的元素中最大的索引,初始值从最后开始,所以长度-1
    int N = heap.length - 1;
    //通过循环,交换1索引处和数组元素中最大索引处的元素
    while (N > 1) {
      //交换元素
      exch(heap, 1, N);
      //将两个索引的值进行交换,然后将最大索引排开,让它不要参与下沉
      N--;
      //从1索引开始进行下沉
      sink(heap, 1, N);
    }
    //把Heap中的数据复制到原数组source中
    System.arraycopy(heap, 1, source, 0, source.length);
  }

  /**
   * 在heap堆中,对target处的元素做下沉运算,范围是0~range
   */
  private static void sink(Comparable[] heap, int target, int range) {
    while (2 * target <= range) {
      //找出当前节点的较大的子节点
      int max;
      if (2 * target + 1 <= range) {
        if (less(heap, target * 2, target * 2 + 1)) {
          max = target * 2 + 1;
        } else {
          max = target * 2;
        }
      } else {
        max = target * 2;
      }
      //比较当前节点的值与较大子节点的值
      if (less(heap, target, max)) {
        exch(heap, target, max);
        target = max;
      } else {
        break;
      }
    }
  }
}
