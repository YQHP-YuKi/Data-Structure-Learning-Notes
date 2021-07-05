package learning;

/**
 * @author YQHP-YuKi
 * @create 2020-12-01 15:09
 */

import com.sun.org.apache.bcel.internal.generic.SWAP;
import com.sun.org.apache.regexp.internal.RE;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import javafx.scene.shape.Circle;
import sun.applet.Main;
import sun.management.Agent;

public class Learn {

  private class Node<Key, Value> {

    //存储键
    public Key key;
    //存储值
    private Value value;
    //记录左子节点
    public Node left;
    //记录右子节点
    public Node right;

    public Node(Key key, Value value, Node left, Node right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
}




