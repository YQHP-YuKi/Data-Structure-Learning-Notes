package linear;


/**
 * @author YQHP-YuKi
 * @create 2021-05-06 9:13
 */
public class JosephTest {

  public static void main(String[] args) {
    //解决约瑟夫问题
    //步骤1:构建循环链表,一共有41个节点,分别是是1-41
    //创建首节点
    Node<Integer> first = null;
    //创建pre节点,用来记录当前节点
    Node<Integer> pre = null;
    for (int i = 1; i <= 41; i++) {
      //如果是第一个节点
      if (i == 1) {
        first = new Node<>(i, null);
        pre = first;
        continue;
      }
      //如果不是第一个节点
      Node<Integer> newNode = new Node<>(i, null);
      pre.next = newNode;
      pre = newNode;
      //如果为最后一个节点,则将它的下一个节点指向first,这样就变为循环链表了,这里需要注意,这时候是已经创建了41节点,再执行的if语句,所以是41指向头结点
      if (i == 41) {
        pre.next = first;
      }
    }
    //步骤2:创建一个count计数器,对其数数进行计数
    int count = 0;
    //步骤3:遍历循环链表
    //定义一个节点作为当前当前位置的节点,此节点从first开始
    Node<Integer> nowNode = first;
    //创建一个节点,记录当前节点的前一个节点,因为此链表没有pre
    Node<Integer> PreNowNode = null;
    //当整个循环链表删除完了后,最后一个节点会自己指向自己,成一个死循环
    while (nowNode != nowNode.next) {
      //计数器先++
      count++;
      //当计数器不为3时,删除此节点,将此节点的前一个节点指向下一个节点
      if (count != 3) {
        //节点变为了第二个,它的前一个节点就变成了第一个first
        PreNowNode = nowNode;
        nowNode = nowNode.next;
      }//当计数器为3时
      else {
        //头结点指向当前节点的下一个节点,相当于删除了当前节点
        PreNowNode.next = nowNode.next;
        System.out.print(nowNode.item + ",");
        //重置计数器
        count = 0;
        //当前节点往后移动,变为下一个节点
        nowNode = nowNode.next;
      }
    }
    //最后剩下那自循环的单个节点,将它输出
    System.out.println(nowNode.item);
  }

  /**
   * 结点类
   */
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
