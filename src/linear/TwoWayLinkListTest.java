package linear;

/**
 * @author YQHP-YuKi
 * @create 2021-04-11 9:40
 */
public class TwoWayLinkListTest {

  public static void main(String[] args) {
    //创建双向链表对象
    TwoWayLinkList<String> sl = new TwoWayLinkList<>();
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
    System.out.println("第一个元素是:" + sl.getFirst());
    System.out.println("最后一个元素是:" + sl.getLast());
    System.out.println("----------------------------");
    //测试获取数据
    String getResult = sl.get(1);
    System.out.println("第一个数据为索引1的:" + getResult);
    System.out.println(sl.get(4));
    //测试删除
    String removeResult = sl.remove(0);
    System.out.println("删除的元素为:+" + removeResult);
    //测试清空
    sl.clear();
    System.out.println("现在顺序表中的元素个数为:" + sl.length());
  }
}
