package linear;

import LiKou.Solution.Node;

/**
 * @author YQHP-YuKi
 * @create 2021-05-05 9:22
 */
public class CycleListTest {

  public static void main(String[] args) throws Exception {
    //构建结点
    Node<Integer> first = new Node<Integer>(1, null);
    Node<Integer> second = new Node<Integer>(2, null);
    Node<Integer> third = new Node<Integer>(3, null);
    Node<Integer> fourth = new Node<Integer>(4, null);
    Node<Integer> fifth = new Node<Integer>(5, null);
    Node<Integer> six = new Node<Integer>(6, null);
    Node<Integer> seven = new Node<Integer>(7, null);
    //构建单链表
    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = six;
    six.next = seven;
    //构建循环链表,让最后一个结点指向第一个结点
    seven.next = first;
  }
}
