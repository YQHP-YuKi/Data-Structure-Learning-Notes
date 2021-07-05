package priority;

/**
 * @author YQHP-YuKi
 * @create 2021-06-17 16:55
 */
public class MaxPriorityQueueTest {

  public static void main(String[] args) {
    //创建优先队列
    MaxPriorityQueue<String> priorityQueue = new MaxPriorityQueue<>(10);
    //往优先队列中存储元素
    priorityQueue.insert("A");
    priorityQueue.insert("B");
    priorityQueue.insert("C");
    priorityQueue.insert("D");
    priorityQueue.insert("E");
    priorityQueue.insert("F");
    priorityQueue.insert("G");
    //从队列中获取最大的元素
    while (!priorityQueue.isEmpty()) {
      String delMax = priorityQueue.delMax();
      System.out.print(delMax+" ");
    }
  }
}
