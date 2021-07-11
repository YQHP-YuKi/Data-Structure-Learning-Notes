package linear;


import java.util.Iterator;

/**
 * @author YQHP-YuKi
 * @create 2021-04-24 9:43
 */
public class TwoWayLinkList<T> implements Iterable<T> {

  /**
   * 首节点
   */
  private Node head;
  /**
   * 尾节点
   */
  private Node last;

  /**
   * 链表的长度
   */
  private int N;


  /**
   * 节点类
   */
  private class Node {

    public Node(T item, Node pre, Node next) {
      this.item = item;
      this.pre = pre;
      this.next = next;
    }

    //存储数据
    public T item;
    //指向上一个节点
    public Node pre;
    //指向下一个节点
    public Node next;
  }

  public TwoWayLinkList() {
    //初始化头结点和尾结点
    this.head = new Node(null, null, null);
    this.last = null;
    //初始化元素个数
    this.N = 0;
  }

  /**
   * 清空链表
   */
  public void clear() {
    //将头结点指向空
    this.head.next = null;
    //将尾结点指向空
    this.last = null;
    //元素个数记为0
    this.N = 0;
  }

  /**
   * 获取链表长度
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
   * 获取第一个元素
   */
  public T getFirst() {
    if (isEmpty()) {
      return null;
    }
    return head.next.item;
  }

  /**
   * 获取最后一个元素
   */
  public T getLast() {
    if (isEmpty()) {
      return null;
    }
    return last.item;
  }

  /**
   * 插入元素t
   */
  public void insert(T t) {
    //如果当前的链表为空,则直接将null的尾结点变为插入的新的元素
    if (isEmpty()) {
      Node newNode = new Node(t, head, null);
      last = newNode;
      head.next = last;
    }//如果当前节点不为空,则直接将新插入的元素变为尾结点,老的尾结点指向新的尾结点
    else {
      Node oldLast = last;
      Node newNode = new Node(t, oldLast, null);
      oldLast.next = newNode;
      last = newNode;
    }
    //元素个数+1
    this.N++;
  }

  /**
   * 向指定位置i处插入元素t
   */
  public void insert(int i, T t) {
    Node swap = head;
    //找到i位置的前一个节点
    for (int index = 0; index < i - 1; index++) {
      swap = swap.next;
    }
    //找到i位置的节点
    Node curr = swap.next;
    //创建一个新的节点,然后前驱结点指向此节点,此节点指向后继节点
    Node newNode = new Node(t, swap, curr);
    swap.next = newNode;
    curr.pre = newNode;
    //元素个数+1
    this.N++;
  }

  /**
   * 获取指定位置i处的元素
   */
  public T get(int i) {
    Node getItem = head.next;
    for (int index = 0; index < i; index++) {
      getItem = getItem.next;
    }
    return getItem.item;
  }

  /**
   * 查找元素t在链表中第一次出现的位置
   */
  public int indexOf(T t) {
    Node findItem = head.next;
    for (int index = 0; findItem.next != null; index++) {
      findItem = findItem.next;
      if (findItem.item.equals(t)) {
        return index;
      }
    }
    return -1;
  }

  /**
   * 删除位置i处的元素,并返回该元素
   */
  public T remove(int i) {
    //找到i位置的前一个节点
    Node swap = head;
    for (int index = 0; index < i - 1; index++) {
      swap = swap.next;
    }
    //找到i位置的节点
    Node curr = swap.next;
    //将i的前一个节点与i的后一个节点连接起来
    swap.next = curr.next;
    curr.next.pre = swap;
    //元素个数-1
    this.N--;
    return curr.item;
  }

  @Override
  public Iterator<T> iterator() {
    return new TestIterator();
  }

  private class TestIterator implements Iterator {

    private Node n;

    public TestIterator() {
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
}
