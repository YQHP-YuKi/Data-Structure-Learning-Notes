package LiKou;


/**
 * @author YQHP-YuKi
 * @create 2020-11-23 17:26
 */


public class Solution {

  public static void main(String[] args) throws Exception {
    //构建节点
    Node<Integer> FirstNumber = new Node<Integer>(5, null);
    Node<Integer> SecondNumber = new Node<Integer>(2, null);
    Node<Integer> ThirdNumber = new Node<Integer>(23, null);
    Node<Integer> FourthNumber = new Node<Integer>(296, null);

    //生成链表
    FirstNumber.next = SecondNumber;
    SecondNumber.next = ThirdNumber;
    ThirdNumber.next = FourthNumber;
  }

  public static class Node<T> {

    //存储元素
    public T item;
    //指向下一个节点
    public Node next;

    public Node(T item, Node next) {
      this.item = item;
      this.next = next;
    }
  }
}


