package linear;

/**
 * @author YQHP-YuKi
 * @create 2021-04-11 9:40
 */
public class LinkListTest2 {

  public static void main(String[] args) {
    //创建单向链表对象
    LinkList<String> sl = new LinkList<>();
    //测试插入
    sl.insert("猪肚鸡");
    sl.insert("蛋包饭");
    sl.insert("乌冬面");
    sl.insert(2, "白切鸡");
    sl.insert(4, "寿司");
    for (String s : sl) {
      System.out.println(s);
    }
    System.out.println("----------------------------");
    sl.reverse();
    for (String s : sl) {
      System.out.println(s);
    }
  }
}
