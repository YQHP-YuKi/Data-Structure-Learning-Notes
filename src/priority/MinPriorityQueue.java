package priority;

/**
 * @author YQHP-YuKi
 * @create 2021-06-17 17:44
 */
public class MinPriorityQueue<T extends Comparable<T>> {

  /**
   * 用来存储元素的数组
   */
  private T[] items;
  /**
   * 记录堆中元素的个数
   */
  private int N;

  /**
   * 创建容量为capacity的MinPriorityQueue对象
   */
  public MinPriorityQueue(int capacity) {
    this.items = (T[]) new Comparable[capacity + 1];
    this.N = 0;
  }

  /**
   * 判断堆中索引i处的元素是否小于索引j处的元素
   */
  private boolean less(int i, int j) {
    return items[i].compareTo(items[j]) < 0;
  }

  /**
   * 交换堆中i索引和j索引处的值
   */
  private void exch(int i, int j) {
    T temp = items[i];
    items[i] = items[j];
    items[j] = temp;
  }

  /**
   * 删除队列中最小的元素,并返回这个最小元素
   */
  public T delMin() {
    T min = items[1];
    exch(1, N);
    items[N] = null;
    N--;
    sink(1);
    return min;
  }

  /**
   * 往队列中插入一个元素
   */
  public void insert(T t) {
    items[++N] = t;
    swim(N);
  }

  /**
   * 使用上浮算法,使索引k处的元素能在堆中处于一个正确的位置
   */
  private void swim(int k) {
    //通过循环比较当前节点和它的父节点的大小
    while (k > 1) {
      if (less(k, k / 2)) {
        //如果比父节点还小,则交换
        exch(k, k / 2);
        k = k / 2;
      } else {
        break;
      }
    }
  }

  /**
   * 使用下沉算法,使索引k处的元素能在堆中处于一个正确的位置
   */
  private void sink(int k) {
    //通过循环比较当前节点与它的子节点的大小
    while (k * 2 <= N) {
      //如果存在右子节点
      int min;
      if (2 * k + 1 <= N) {
        //也存在左子节点,并且左子节点小于右子节点
        if (less(2 * k, 2 * k + 1)) {
          min = 2 * k;
        } else {
          min = 2 * k + 1;
        }
      }//如果不存在右子节点,直接min等于左子节点
      else {
        min = 2 * k;
      }
      //如果当前节点比min小,则不换
      if (less(k, min)) {
        break;
      }//如果小于,则换
      else {
        exch(k, min);
        k = min;
      }
    }
  }

  /**
   * 获取队列中元素的个数
   */
  public int size() {
    return N;
  }

  /**
   * 判断优先队列是否为空
   */
  public boolean isEmpty() {
    return N == 0;
  }
}
