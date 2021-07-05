package linear;

/**
 * @author YQHP-YuKi
 * @create 2021-05-11 9:16
 */
public class BracketsMatchTest {

  public static void main(String[] args) {
    String str = "(Java(C++)())";
    boolean match = isMatch(str);
    System.out.println(str + "中的括号是否匹配:" + match);
  }

  /**
   * 判断str中的括号是否匹配,如果匹配则返回true,如果不匹配则返回false
   */
  public static boolean isMatch(String str) {
    //创建栈对象,用来存储左括号
    Stack<String> chars = new Stack<>();
    //从左往右遍历整个链表
    for (int i = 0; i < str.length(); i++) {
      //将字符转换为字符串,因为栈是String类型,此转换方法效率最高
      String currChar = String.valueOf(str.charAt(i));
      //判断当前的字符是否是左括号,如果是左括号,则压入栈中
      if ("(".equals(currChar)) { //千万不要使用==运算符测试字符串的相等性，以免在程序中出现糟糕的 bug。从表面上看，这种 bug 很像随机产生的间歇性错误。
        chars.push(currChar);
      }    //继续判断当前字符是否是右括号,如果是,则从栈中弹栈,如果弹出结果不为null,则还存有左括号,如果结果为null,则证明栈为空,返回false
      else if (")".equals(currChar)) {
        String StringPop = chars.pop();
        if (StringPop == null) {
          return false;
        }
      }
    }
    //当遍历完了后,还需判断栈中是否为空,如果不为空,则还剩余左括号,同样返回false,如果为空,则都匹配完毕,返回true
    if (chars.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }
}
