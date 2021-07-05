package linear;

import java.util.Iterator;
import javax.swing.Renderer;

/**
 * @author YQHP-YuKi
 * @create 2021-04-17 16:15
 */
public class LinkList<T> implements Iterable<T> {

  /**
   * 记录头结点
   */
  private Node head;
  /**
   * 记录链表长度
   */
  private int N;


  /**
   * 节点类
   */
  private class Node {

    //存储数据
    T item;
    //下一个节点
    Node next;

    public Node(T item, Node next) {
      this.item = item;
      this.next = next;
    }
  }

  public LinkList() {
    //初始化头结点
    this.head = new Node(null, null);
    //初始化元素个数
    this.N = 0;
  }

  /**
   * 清空链表
   */
  public void clear() {
    //只需将头结点与后面的指针断开并且将元素个数变为0,就可以清空了
    this.head.next = null;
    this.N = 0;
  }

  /**
   * 获取链表的长度
   */
  public int length() {
    return N;
  }

  /**
   * 判断链表是否为空
   */
  public boolean isEmpty() {
    return N == 0;
  }

  /**
   * 获得指定位置i的元素
   */
  public T get(int i) {
    //因为不能像顺序表一样直接找出,所以我们只能用头结点向后面依次循环寻找i次,才能找到
    Node n = head.next;
    for (int index = 0; index < i; index++) {
      n = n.next;
    }
    return n.item;
  }

  /**
   * 向链表中添加元素t
   */
  public void insert(T t) {
    //找到当前单链表最后的一个节点
    Node n = head;
    while (n.next != null) {
      n = n.next;
    }
    //创建一个新的节点.保存t
    Node newNode = new Node(t, null);
    n.next = newNode;
    //元素个数++
    this.N++;
  }

  /**
   * 向指定位置i处添加元素t
   */
  public void insert(int i, T t) {
    //找到i位置的前一个节点
    Node pre = head;
    for (int index = 0; index < i - 1; index++) {
      pre = pre.next;
    }
    //找到i位置的节点
    Node curr = pre.next;
    //将原来i也就是pre指向新的要插入的节点即可
    Node newNode = new Node(t, curr);
    pre.next = newNode;
    //元素个数++
    this.N++;
  }

  /**
   * 删除指定位置i处的元素,并返回被删除的值
   */
  public T remove(int i) {
    //同样的,要先去找到i的前一个节点,然后直接指向i的后一个节点,i则直接指向null
    Node pre = head;
    for (int index = 0; index < i - 1; index++) {
      pre = pre.next;
    }
    //找到i节点
    Node curr = pre.next;
    //将i-1指向i+1,i指向null
    pre.next = curr.next;
    curr.next = null;
    //元素个数--
    this.N--;
    //返回被删除的元素
    return curr.item;
  }

  /**
   * 查找元素t在链表中第一次出现的位置
   */
  public int indexOf(T t) {
    //从头结点开始,依次遍历每一个节点,让其中的item与t做比较,如果相同,则返回i
    Node search = head;
    for (int index = 0; search.next != null; index++) {
      if (search.item == t) {
        return index;
      } else {
        search = search.next;
      }
    }
    return -1;
  }

  @Override
  public Iterator<T> iterator() {
    return new lIterator();
  }

  private class lIterator implements Iterator {

    private Node n;

    public lIterator() {
      this.n = head;
    }

    @Override
    public boolean hasNext() {
      return n.next != null;
    }

    @Override
    public Object next() {
      n = n.next;
      return n.item;
    }
  }

  /**
   * 反转整个链表
   */
  public void reverse() {
    //判断当前链表是否为空,如果为空,那么直接返回结束运行,如果不为空,则调用重载的reverse进行链条反转
    if (isEmpty()) {
      return;
    }
    reverse(head.next);
  }

  /**
   * 反转指定的节点curr,并把反转后的节点返回
   */
  public Node reverse(Node curr) {
    //递归的结束条件,当前节点的下一个节点为null,那么将头结点的下一节点指向为curr
    if (curr.next == null) {
      head.next = curr;
      return curr;
    }
    //递归反转当前节点的下一个节点,返回值就是链表反转后,curr的下一节点反转后就变成了他的上一节点
    Node pre = reverse(curr.next);
    //本来是下一节点的pre变成了上一节点,让上一节点pre指向当前节点curr
    pre.next = curr;
    //把当前节点curr的下一节点变为null,防止链表循环，1指向null
    curr.next = null;
    return curr;
  }
}
