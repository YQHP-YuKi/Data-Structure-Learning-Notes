package symbol;

/**
 * @author YQHP-YuKi
 * @create 2021-05-28 10:34
 */
public class SymbolTable<Key, Value> {

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

  public SymbolTable() {
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
    //情况1:如果符号表中已经存在键为key的键值对,那么只需要找到该节点,修改key相对应的value即可,但是此情况,元素个数N是不需要+1的
    Node n = head;
    while (n.next != null) {
      n = n.next;
      if (n.key == key) {
        n.value = value;
        return;
      }
    }
    //情况2:如果符号表中不存在键为key的键值对,则需要创建新的节点,保存要插入的键值对,使用头插法,将head指向新插入的键值对即可
    Node newNode = new Node(key, value, null);
    newNode.next = head.next;
    head.next = newNode;
    //元素个数+1
    this.N++;
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
