package linear;

/**
 * @author YQHP-YuKi
 * @create 2021-05-16 11:21
 */
public class QueueTest {

  public static void main(String[] args) {
    //创建一个队列对象
    Queue<String> Que = new Queue<>();
    //测试队列enqueue方法
    Que.enqueue("a");
    Que.enqueue("b");
    Que.enqueue("c");
    Que.enqueue("1");
    Que.enqueue("2");
    Que.enqueue("3");
    Que.enqueue("z");
    for (String str : Que) {
      System.out.println(str);
    }
    System.out.println("--------------------------");
    String result = Que.dequeue();
    System.out.println("出队列的元素为=" + result);
    System.out.println("剩余的元素个数=" + Que.size());
    //测试队列的dequeue方法
  }
}
