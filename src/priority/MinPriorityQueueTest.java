package priority;

/**
 * @author YQHP-YuKi
 * @create 2021-06-17 22:52
 */
public class MinPriorityQueueTest {

  public static void main(String[] args) {
    //创建最小优先队列对象
    MinPriorityQueue<String> minPriorityQueue = new MinPriorityQueue<>(10);
    //存入数据
    minPriorityQueue.insert("G");
    minPriorityQueue.insert("F");
    minPriorityQueue.insert("E");
    minPriorityQueue.insert("D");
    minPriorityQueue.insert("C");
    minPriorityQueue.insert("B");
    minPriorityQueue.insert("A");
    //通过循环得到最小优先队列的元素
    while (!minPriorityQueue.isEmpty()) {
      String delMin = minPriorityQueue.delMin();
      System.out.print(delMin + " ");
    }
  }
}
