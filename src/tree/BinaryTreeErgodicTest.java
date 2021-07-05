package tree;

import linear.Queue;

/**
 * @author YQHP-YuKi
 * @create 2021-06-14 11:10
 */
public class BinaryTreeErgodicTest {

  public static void main(String[] args) {
    //创建树对象
    BinaryTree<String, String> stringStringBinaryTree = new BinaryTree<>();
    //往树中添加数据,进行前序遍历测试
    stringStringBinaryTree.put("E", "5");
    stringStringBinaryTree.put("B", "2");
    stringStringBinaryTree.put("G", "7");
    stringStringBinaryTree.put("A", "1");
    stringStringBinaryTree.put("D", "4");
    stringStringBinaryTree.put("F", "6");
    stringStringBinaryTree.put("H", "8");
    stringStringBinaryTree.put("C", "3");
    //前序遍历
    //Queue<String> keys = stringStringBinaryTree.preErgodic();
    //中序遍历
    //Queue<String> keys = stringStringBinaryTree.midErgodic();
    //后序遍历
    //Queue<String> keys = stringStringBinaryTree.afterErgodic();
    //层序遍历
    Queue<String> keys = stringStringBinaryTree.layerErgodic();
    for (String key : keys) {
      String value = stringStringBinaryTree.get(key);
      System.out.println(key + "=" + value);
    }
  }
}
