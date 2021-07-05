package linear;

import java.util.Iterator;

/**
 * @author YQHP-YuKi
 * @create 2021-05-16 10:48
 */
public class Queue<T> implements Iterable<T> {

  /**
   * 记录首节点
   */
  private Node head;
  /**
   * 记录尾结点
   */
  private Node last;
  /**
   * 记录队列中元素的个数
   */
  private int N;


  private class Node {

    public T item;
    public Node next;

    public Node(T item, Node next) {
      this.item = item;
      this.next = next;
    }
  }

  public Queue() {
    this.head = new Node(null, null);
    this.last = null;
    this.N = 0;
  }

  /**
   * 判断队列是否为空
   */
  public boolean isEmpty() {
    return N == 0;
  }

  /**
   * 返回队列中元素的个数
   */
  public int size() {
    return N;
  }

  /**
   * 向队列中插入元素t
   */
  public void enqueue(T t) {
    //如果尾结点为null
    if (last == null) {
      last = new Node(t, null);
      head.next = last;
    }//如果尾结点不为null
    else {
      Node OldLast = last;
      last = new Node(t, null);
      OldLast.next = last;
    }
    //元素个数+1
    this.N++;
  }

  /**
   * 从队列中拿出一个元素
   */
  public T dequeue() {
    //如果元素个数为0,直接返回null
    if (isEmpty()) {
      return null;
    }
    //将头结点指向新的第一个节点也就是原来的第二个节点
    Node OldFirst = head.next;
    head.next = OldFirst.next;
    //元素个数-1
    this.N--;
    //出队列是在删除元素,当元素全部被删除后,就相当于没有last这个节点了,所以需要重置一个last节点
    if (isEmpty()) {
      last = null;
    }
    return OldFirst.item;
  }

  @Override
  public Iterator<T> iterator() {
    return new QIterator();
  }

  private class QIterator implements Iterator {

    private Node n;

    public QIterator() {
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
