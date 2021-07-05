package linear;

import java.io.PushbackInputStream;
import java.util.Currency;
import java.util.Iterator;
import javax.lang.model.util.ElementScanner6;

/**
 * @author YQHP-YuKi
 * @create 2021-04-09 11:10
 */
public class SequenceList<T> implements Iterable<T> {

  /**
   * 存储元素的数组
   */
  private T[] eles;

  /**
   * 记录当前顺序表中的元素个数
   */
  private int N;

  /**
   * 构造方法
   */
  public SequenceList(int capacity) {
    //初始化数组
    this.eles = (T[]) new Object[capacity];
    //初始化长度
    this.N = 0;

  }

  /**
   * 将一个线性表置为空表
   */
  public void clear() {
    this.N = 0;
  }

  /**
   * 判断当前线性表是否为空表
   */
  public boolean isEmpty() {
    return N == 0;
  }

  /**
   * 获取线性表的长度
   */
  public int length() {
    return N;
  }

  /**
   * 获取指定位置的元素
   */
  public T get(int i) {
    return eles[i];
  }

  /**
   * 向线性表中添加元素t
   */
  public void insert(T t) {
    //扩大数组
    if (N == eles.length) {
      resize(N * 2);
    }
    eles[N++] = t;
  }

  /**
   * 在i元素处插入元素t
   */
  public void insert(int i, T t) {
    //扩大数组
    if (N == eles.length) {
      resize(N * 2);
    }
    //元素个数加1
    this.N++;
    //先把i索引处的元素及其后面的元素依次向后移动一位
    for (int index = N - 1; index > i; index--) {
      eles[index] = eles[index - 1];
    }
    //再把t元素放到位置i即可,这时候需要考虑如果插入的数的位置是原数组最后一个,则直接else[N++]=t;
    if (i == N - 2) {
      eles[i + 1] = t;
    } else {
      eles[i] = t;
    }
  }

  /**
   * 删除指定位置i处的元素,并返回该元素
   */
  public T remove(int i) {
    //记录索引i处的值
    T current = eles[i];
    //让索引i后面元素依次向前移动一位
    for (int index = i; index < N - 1; index++) {
      eles[index] = eles[index + 1];
    }
    //元素个数减1
    this.N--;


    //缩小数组
    if (N < eles.length / 4) {
      resize(eles.length / 2);
    }
    return current;
  }

  /**
   * 查找t元素第一次出现的位置
   */
  public int indexOf(T t) {
    for (int index = 0; index < N; index++) {
      if (eles[index] == t) {
        return index;
      }
    }
    return -1;
  }

  /**
   * 根据newSize,重置数组eles的长度大小
   */
  public void resize(int newSize) {
    //定义一个临时数组,指向原数组
    T[] temp = eles;
    //创建新数组
    eles = (T[]) new Object[newSize];
    //把原数组的数据拷贝到新数组即可
    for (int i = 0; i < N; i++) {
      eles[i] = temp[i];
    }
  }

  @Override
  public Iterator<T> iterator() {
    return new SIterator();
  }

  private class SIterator implements Iterator {

    private int cusor;

    public SIterator() {
      this.cusor = 0;
    }

    @Override
    public boolean hasNext() {
      return cusor <= N - 1;
    }

    @Override
    public Object next() {
      return eles[cusor++];
    }
  }
}
