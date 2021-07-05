package linear;

import java.util.Iterator;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 * @author YQHP-YuKi
 * @create 2021-05-08 11:01
 */
public class Stack<T> implements Iterable<T> {

  /**
   * 记录头结点
   */
  private Node head;
  /**
   * 栈中元素的个数
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

  public Stack() {
    //初始化头结点与元素个数
    this.head = new Node(null, null);
    this.N = 0;
  }

  /**
   * 判断当前栈中元素是否为0
   */
  public boolean isEmpty() {
    return N == 0;
  }

  /**
   * 获取栈中元素的个数
   */
  public int siza() {
    return N;
  }

  /**
   * 把t元素压入栈
   */
  public void push(T t) {
    //找到头结点指向的第一个节点
    Node OldFirst = head.next;
    //创建要插入的的节点
    Node newNode = new Node(t, null);
    //将头结点重新指向要插入的节点
    head.next = newNode;
    //将要插入的节点指向原来的第一个节点
    newNode.next = OldFirst;
    //元素个数++
    N++;
  }

  /**
   * 弹出栈顶的元素
   */
  public T pop() {
    //直接将头结点指向第二个节点,第一个节点指向null,但这里特别需要注意,如果栈里的个数没有了,就会指向空指针,不安全
    Node OldFirst = head.next;
    if (OldFirst == null) {
      return null;
    }
    head.next = OldFirst.next;
    //元素个数--
    N--;
    return OldFirst.item;
  }

  @Override
  public Iterator<T> iterator() {
    return new SIterator();
  }

  private class SIterator implements Iterator {

    private Node n;

    public SIterator() {
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
