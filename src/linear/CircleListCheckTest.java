package linear;

public class CircleListCheckTest {

  public static void main(String[] args) throws Exception {
    //创建结点
    Node<String> first = new Node<String>("aa", null);
    Node<String> second = new Node<String>("bb", null);
    Node<String> third = new Node<String>("cc", null);
    Node<String> fourth = new Node<String>("dd", null);
    Node<String> fifth = new Node<String>("ee", null);
    Node<String> six = new Node<String>("ff", null);
    Node<String> seven = new Node<String>("gg", null);

    //完成结点之间的指向
    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = six;
    six.next = seven;
    //产生环
    seven.next = third;

    //判断链表是否有环
    boolean circle = isCircle(first);
    System.out.println("first链表中是否有环：" + circle);
  }

  /**
   * 判断链表中是否有环
   *
   * @param first 链表首结点
   * @return ture为有环，false为无环
   */
  public static boolean isCircle(Node<String> first) {
    //定义快慢指针
    Node<String> fast = first, slow = first;
    //遍历链表,如果快慢指针都指向同一个节点,那么就说明有环,如果快指针走完所有节点,仍然没遇见慢指针,就说明无环
    while (fast.next != null && fast.next.next != null) {
      //移动fast与slow,两者速度不同
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    //没找到,返回错误
    return false;
  }

  //结点类
  private static class Node<T> {

    //存储数据
    T item;
    //下一个结点
    Node next;

    public Node(T item, Node next) {
      this.item = item;
      this.next = next;
    }
  }
}
