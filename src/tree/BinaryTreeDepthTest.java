package tree;

import linear.Queue;

/**
 * @author YQHP-YuKi
 * @create 2021-06-14 11:10
 */
public class BinaryTreeDepthTest {

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
    //测试求最大深度方法
    int maxDepth = stringStringBinaryTree.maxDepth();
    System.out.println("此树的最大深度为:" + maxDepth);
  }
}
