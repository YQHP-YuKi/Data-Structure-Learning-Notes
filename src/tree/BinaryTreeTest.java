package tree;

/**
 * @author YQHP-YuKi
 * @create 2021-06-05 11:00
 */
public class BinaryTreeTest {

  public static void main(String[] args) {
    //创建二叉查找树对象
    BinaryTree<Integer, String> tree = new BinaryTree<>();
    //测试插入
    tree.put(1, "GAT5");
    tree.put(2, "PUBG");
    tree.put(3, "LOL");
    tree.put(4, "APEX");
    tree.put(5, "CSGO");
    System.out.println("插入完毕后的元素个数:" + tree.size());
    //测试查找
    System.out.println("键4对应的元素为:" + tree.get(4));
    //测试删除
    tree.delete(3);
    System.out.println("删除后元素对应的个数:" + tree.size());
    System.out.println("删除后键3是否存在,删除成功后应该返回null:" + tree.get(3));
    //如果没找到要删除的元素,则个数不变
  }

}
