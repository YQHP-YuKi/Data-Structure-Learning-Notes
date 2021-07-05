package linear;

/**
 * @author YQHP-YuKi
 * @create 2021-04-12 16:26
 */
public class SequenceListTest2 {

  public static void main(String[] args) {
    SequenceList<String> sl = new SequenceList<>(3);
    sl.insert("上海");
    sl.insert("东京");
    sl.insert("纽约");
    sl.insert("巴黎");
  }
}
