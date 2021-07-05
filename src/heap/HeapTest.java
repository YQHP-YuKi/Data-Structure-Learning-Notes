package heap;

/**
 * @author YQHP-YuKi
 * @create 2021-06-16 16:23
 */
public class HeapTest {

  public static void main(String[] args) {
    //创建堆对象
    Heap<String> stringHeap = new Heap<>(10);
    //往堆中存入字符串数据
    stringHeap.insert("A");
    stringHeap.insert("B");
    stringHeap.insert("C");
    stringHeap.insert("D");
    stringHeap.insert("E");
    stringHeap.insert("F");
    stringHeap.insert("G");
    //通过循环从堆中删除数据
    String result = null;
    while ((result = stringHeap.delMax()) != null) {
      System.out.print(result + " ");
    }
  }
}
