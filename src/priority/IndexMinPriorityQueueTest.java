package priority;


/**
 * @author YQHP-YuKi
 * @create 2021-06-19 9:16
 */
public class IndexMinPriorityQueueTest {

  public static void main(String[] args) {
    //创建索引最小优先队列对象
    IndexMinPriorityQueue<String> testIndex = new IndexMinPriorityQueue<>(10);
    //往队列中添加元素
    testIndex.insert(0, "A");
    testIndex.insert(1, "C");
    testIndex.insert(2, "F");
    testIndex.insert(3, "G");
    //测试修改
    testIndex.changeItem(2, "B");
    //测试删除
    while (!testIndex.isEmpty()) {
      int minIndex = testIndex.delMin();
      System.out.print(minIndex + " ");
    }
  }
}
