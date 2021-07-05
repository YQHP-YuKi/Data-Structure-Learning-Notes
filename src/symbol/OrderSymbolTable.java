package symbol;

/**
 * @author YQHP-YuKi
 * @create 2021-05-28 10:34
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {

  /**
   * 记录首节点
   */
  private Node head;
  /**
   * 记录符号表中元素的个数
   */
  private int N;

  private class Node {

    //    键
    public Key key;
    //值
    public Value value;
    //    下一个节点
    public Node next;

    public Node(Key key, Value value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  public OrderSymbolTable() {
    //初始化头结点
    this.head = new Node(null, null, null);
    this.N = 0;
  }

  /**
   * 获取符号表中键值对的个数
   */
  public int size() {
    return N;
  }

  /**
   * 往符号表中插入键值对
   */
  public void put(Key key, Value value) {
    //定义两个节点,分别记录当前节点与当前节点的前一个节点
    Node curr = head.next;
    Node pre = head;
    while (curr != null && key.compareTo(curr.key) > 0) {
      //变换当前节点与上一个节点即可
      pre = curr;
      curr = curr.next;
    }
    //如果当前节点的key键与要插入的key键的值一样,则替换
    if (curr != null && curr.key == key) {
      curr.value = value;
      return;
    }
    //如果小于curr,则插入到curr之前即可
    Node newNode = new Node(key, value, curr);
    pre.next = newNode;
    //元素个数+1
    N++;
  }

  /**
   * 删除符号表中键为key的键值对
   */
  public void delete(Key key) {
    //找到键为key的键值对,把该节点从链表中删除
    Node n = head;
    while (n.next != null) {
      //判断n节点的下一个节点是否为key,如果是,则直接删除
      if (n.next.key == key) {
        n.next = n.next.next;
        //元素个数-1
        this.N--;
        return;
      }
      //继续往后找
      n = n.next;
    }
  }

  /**
   * 从符号表中获取key对应的值
   */
  public Value get(Key key) {
    //找到key所在的节点
    Node n = head;
    while (n.next != null) {
      if (n.next.key == key) {
        return n.next.value;
      }
      //继续往后找
      n = n.next;
    }
    return null;
  }
}
