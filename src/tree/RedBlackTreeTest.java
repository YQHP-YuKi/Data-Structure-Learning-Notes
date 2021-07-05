package tree;

/**
 * @author YQHP-YuKi
 * @create 2021-06-23 10:24
 */
public class RedBlackTreeTest {

  public static void main(String[] args) {
    //创建红黑树
    RedBlackTree<String, String> redBlackTree = new RedBlackTree<>();
    //往树中插入元素
    redBlackTree.put("1", "java");
    redBlackTree.put("2", "C");
    redBlackTree.put("3", "php");
    //从树中获取元素
    String r1 = redBlackTree.get("1");
    System.out.println(r1);
    String r2 = redBlackTree.get("2");
    System.out.println(r2);
    String r3 = redBlackTree.get("3");
    System.out.println(r3);
  }
}
