package LiKou;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import java.awt.HeadlessException;
import java.awt.font.NumericShaper;
import java.security.PublicKey;
import java.time.chrono.IsoChronology;
import java.util.Arrays;

/**
 * @author YQHP-YuKi
 * @create 2020-11-23 17:26
 */

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import sun.security.util.Length;

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


