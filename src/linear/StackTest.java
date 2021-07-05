package linear;

/**
 * @author YQHP-YuKi
 * @create 2021-05-10 16:41
 */
public class StackTest {

  public static void main(String[] args) {
    //创建栈对象
    Stack<String> stack = new Stack<>();
    //测试压栈
    stack.push("a");
    stack.push("b");
    stack.push("c");
    stack.push("1");
    stack.push("2");
    stack.push("3");
    for (String item : stack) {
      System.out.println(item);
    }
    System.out.println("***************************");
    //测试弹栈
    String result = stack.pop();
    System.out.println("弹出的元素是 =" + result);
    System.out.println("剩余的元素个数 =" + stack.siza());
  }
}
