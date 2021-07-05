package linear;

public class FastSlowTest {

  public static void main(String[] args) throws Exception {
    //创建结点
    Node<String> first = new Node<String>("aa", null);
    Node<String> second = new Node<String>("bb", null);
    Node<String> third = new Node<String>("cc", null);
    Node<String> fourth = new Node<String>("dd", null);
    Node<String> fifth = new Node<String>("ee", null);
    Node<String> six = new Node<String>("ff", null);
    Node<String> seven = new Node<String>("gg", null);
    Node<String> eight = new Node<String>("zz", null);
    //完成结点之间的指向
    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = six;
    six.next = seven;
    seven.next = eight;

    //查找中间值
    String mid = getMid(first);
    System.out.println("中间值为：" + mid);
  }

  /**
   * @param first 链表的首结点
   * @return 链表的中间结点的值
   */
  public static String getMid(Node<String> first) {
    //定义两个指针,一个慢指针,一个快指针
    Node<String> fast = first, slow = first;
    //让两个指针遍历链表,当快指针指向的节点没有下一个节点了,就表示跑完了,然后就可以返回慢指针了
    while (fast.next != null && fast.next.next != null) {
      //fast跑两个节点
      fast = fast.next.next;
      //slow跑一个节点
      slow = slow.next;
    }
    return slow.item;
  }

  //结点类
  private static class Node<T> {

    //存储数据
    T item;
    //下一个节点
    Node next;

    public Node(T item, Node next) {
      this.item = item;
      this.next = next;
    }
  }
}
