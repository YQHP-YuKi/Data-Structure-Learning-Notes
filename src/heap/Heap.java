package heap;

/**
 * @author YQHP-YuKi
 * @create 2021-06-16 10:16
 */
public class Heap<T extends Comparable<T>> {

  /**
   * 存储堆中的元素
   */
  private T[] items;
  /**
   * 记录堆中元素的个数
   */
  private int N;

  /**
   * 创建容量为capacity的Heap对象
   */
  public Heap(int capacity) {
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
   * 删除堆中最大的元素,并返回这个最大元素
   */
  public T delMax() {
    T max = items[1];
    //交换索引1处的元素和最大索引处的元素(也就是数组最后个元素),让完全二叉树中最右侧的元素变为临时根节点
    exch(1, N);
    //删除掉最大索引处的元素
    items[N] = null;
    //元素个数-1
    N--;
    //使用下沉算法调整,让堆重新有序
    sink(1);
    return max;
  }

  /**
   * 往堆中插入一个元素
   */
  public void insert(T t) {
    //因为堆是从数组第1个位置开始的,所以是++N,成功跳过0位置
    items[++N] = t;
    //又因为是从数组尾部插入,如果遇到插入的元素比他的父节点更大,就需要使用上浮算法,从下到上进行寻找正确的位置
    swim(N);
  }

  /**
   * 使用上浮算法,使索引k处的元素能在堆中处于一个正确的位置
   */
  private void swim(int k) {
//通过循环,不断的比较当前节点的值和其父节点的值,如果其父节点小于当前节点,则交换位置
    while (k > 1) {
      //比较当前节点与它父节点,交换元素
      if (less(k / 2, k)) {
        exch(k / 2, k);
        //再变化k值
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
    //通过循环,不断的比较当前节点的值与其两个节点(左子节点与右子节点)的值,与其中大的子节点进行交换位置
    while (2 * k <= N) {
      //获取当前节点的子节点中的较大节点
      //记录较大节点所在的索引
      int max;
      //如果有右子节点
      if (2 * k + 1 <= N) {
        //如果左子节点小于右子节点,则max为右子节点
        if (less(2 * k, 2 * k + 1)) {
          max = 2 * k + 1;
        }//相反则max为左子节点
        else {
          max = 2 * k;
        }
      }//若果没有右子节点,则只有一个左子节点,直接令max=左子节点即可
      else {
        max = 2 * k;
      }
      //比较当前节点与较大子节点的值
      //如果当前节点的值比子节点的值小,则交换
      if (less(k, max)) {
        exch(k, max);
      }//大于则不用继续循环了,直接break
      else {
        break;
      }
      //最后还要更新变换k的值
      k = max;
    }
  }
}
