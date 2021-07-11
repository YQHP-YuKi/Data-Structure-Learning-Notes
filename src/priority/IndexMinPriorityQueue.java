package priority;


/**
 * @author YQHP-YuKi
 * @create 2021-06-18 11:15
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {

  /**
   * 用来存储元素的数组
   */
  private T[] items;
  /**
   * 保存每个元素在items数组中的索引,pq数组需要堆有序
   */
  private int[] pq;
  /**
   * 保存qp的逆序,pq的值作为索引,pq的索引作为值
   */
  private int[] qp;
  /**
   * 记录堆中元素的个数
   */
  private int N;

  /**
   * 创建容量为capacity的IndexMinPriorityQueue对象
   */
  public IndexMinPriorityQueue(int capacity) {
    this.items = (T[]) new Comparable[capacity + 1];
    this.pq = new int[capacity + 1];
    this.qp = new int[capacity + 1];
    this.N = 0;
    //默认情况下,队列中没有存储任何事数据,让qp中的所有元素都为-1
    for (int i = 0; i < qp.length; i++) {
      qp[i] = -1;
    }
  }

  /**
   * 判断堆中索引i处的元素是否小于索引j处的元素
   */
  private boolean less(int i, int j) {
    return items[pq[i]].compareTo(items[pq[j]]) < 0;
  }

  /**
   * 交换堆中i索引和j索引处的值
   */
  private void exch(int i, int j) {
    //交换pq中的数据
    int temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
    //更新qp中的数据
    qp[pq[i]] = i;
    qp[pq[j]] = j;
  }

  /**
   * 删除队列中最小的元素,并返回该元素关联的索引
   */
  public int delMin() {
    //获取最小元素关联的索引
    int minIndex = pq[1];
    //交换pq中索引1处和最大索引处的元素
    exch(1, N);
//删除qp中对应的逆序内容
    qp[pq[N]] = -1;
    //删除pq中最大索引的内容
    pq[N] = -1;
    //删除items中对应的内容
    items[minIndex] = null;
    //元素个数-1
    N--;
    //对堆进行下沉调整
    sink(1);
    return minIndex;
  }

  /**
   * 往队列中插入一个元素,并关联索引i
   */
  public void insert(int i, T t) {
//判断i是否已经被关联,如果已经被关联,则不让插入
    if (contains(i)) {
      return;
    } else {
      //元素个数+1
      N++;
      //把数据存储到items对应的i位置
      items[i] = t;
      //把i存储到pq中
      pq[N] = i;
      //通过qp来记录pq中的i
      qp[i] = N;
      //通过上浮算法来进行堆的调整
      swim(N);
    }
  }

  /**
   * 使用上浮算法,使索引k处的元素能在堆中处于一个正确的位置
   */
  private void swim(int k) {
    while (k > 1) {
      if (less(k, k / 2)) {
        exch(k, k / 2);
        k = k / 2;
      } else {
        break;
      }
    }
  }

  /**
   * 使用下沉算法,使索引k处的元素能在堆中处于一个正确的卫视
   */
  private void sink(int k) {
    while (2 * k <= N) {
      int min;
      if (2 * k + 1 <= N) {
        if (less(2 * k, 2 * k + 1)) {
          min = 2 * k;
        } else {
          min = 2 * k + 1;
        }
      } else {
        min = 2 * k;
      }
      if (less(k, min)) {
        break;
      } else {
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
   * 判断队列是否为空
   */
  public boolean isEmpty() {
    return N == 0;
  }

  /**
   * 判断k对应的元素是否存在
   */
  public boolean contains(int k) {
    return qp[k] != -1;
  }

  /**
   * 把与索引i有关的元素修改为t
   */
  public void changeItem(int i, T t) {
    //修改items中位置为i的值为t
    items[i] = t;
    //找到i在pq中出现的位置
    int i1 = qp[i];
    //堆pq的调整
    swim(i1);
    sink(i1);
  }

  /**
   * 最小元素相关联的索引
   */
  public int minIndex() {
    return pq[1];
  }

  /**
   * 删除索引i相关联的元素
   */
  public void delete(int i) {
//找到i在pq中对应的索引
    int i1 = qp[i];
    //交换pq中索引i1的值与最后索引N的值
    exch(i1, N);
    //删除qp中原有的内容
    qp[pq[N]] = -1;
    //删除pq最后的内容
    pq[N] = -1;
    //删除items中的内容
    items[i1] = null;
    //元素数量-1
    N--;
    //先做上浮调整
    swim(i1);
    //再做下沉调整
    sink(i1);
  }
}
