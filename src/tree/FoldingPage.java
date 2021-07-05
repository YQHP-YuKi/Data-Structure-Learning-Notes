package tree;

import LiKou.Solution.Node;
import linear.Queue;

/**
 * @author YQHP-YuKi
 * @create 2021-06-15 19:51
 */
public class FoldingPage {

  public static void main(String[] args) {
    //模拟折纸过程,生成以第一个折痕为根节点的树
    Node<String> threeFold = createTree(3);
    //遍历树,打印出每一个折痕节点
    printTree(threeFold);
  }

  /**
   * 通过模拟对折N次,产生一个深度为N的树
   */
  private static Node<String> createTree(int N) {
    //因为最后要返回一个Node类型的节点,所以我们定义一个String类型的根节点
    Node<String> root = null;
    for (int i = 0; i < N; i++) {
      //情况1:当前是第一次对折,创建根节点
      if (i == 0) {
        root = new Node<String>("down", null, null);
      } else {
        //情况2:当不是第一次对折时
        //定义一个辅助的队列,通过层序遍历的思想,找到叶子节点,为叶子节点添加子节点,因为只会在叶子节点添加,这是因为不会在上面层数添加
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(root);
        //循环遍历队列
        while (!nodes.isEmpty()) {
          //从队列中弹出一个节点
          Node<String> deNode = nodes.dequeue();
          //如果此节点有左子节点,则将左子节点放入到队列中
          if (deNode.left != null) {
            nodes.enqueue(deNode.left);
          }
          //如果此节点有右子节点,则将右子节点放入到队列中
          if (deNode.right != null) {
            nodes.enqueue(deNode.right);
          }
          //如果此节点既没有左子节点,也无右子节点,则证明已经找到了最下面一层的叶子节点,为其添加左子节点和右子节点即可
          if (deNode.left == null && deNode.right == null) {
            //左子节点为下折痕down
            deNode.left = new Node<String>("down", null, null);
            //右子节点为上折痕up
            deNode.right = new Node<String>("up", null, null);
          }
        }
      }
    }
    return root;
  }

  /**
   * 打印树中的每一个节点到控制台
   */
  public static void printTree(Node<String> root) {
    //使用中序遍历进行遍历
    if (root == null) {
      return;
    }
    //打印左子树的每一个节点
    if (root.left != null) {
      printTree(root.left);
    }
    //打印当前节点;
    System.out.print(root.item + ",");
    //打印右子树的每一个节点
    if (root.right != null) {
      printTree(root.right);
    }
  }

  /**
   * 创建树的节点类
   */
  private static class Node<T> {

    //存储元素
    public T item;
    //左子节点
    public Node left;
    //右子节点
    public Node right;

    public Node(T item, Node left, Node right) {
      this.item = item;
      this.left = left;
      this.right = right;
    }
  }
}
