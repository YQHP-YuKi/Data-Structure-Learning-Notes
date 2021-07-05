package linear;

/**
 * @author YQHP-YuKi
 * @create 2021-05-16 9:46
 */
public class ReversePolishNotationTest {

  public static void main(String[] args) {
    //中缀表达式3*(17-15)+18/6,逆波兰表达式如下
    String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
    int result = caculation(notation);
    System.out.println("逆波兰表达式的结果=" + result);
  }

  public static int caculation(String[] notation) {
    //定义一个栈,用来存储操作数
    Stack<Integer> operans = new Stack<>();
    //从左往右遍历逆波兰表达式,得到每一个元素
    for (int i = 0; i < notation.length; i++) {
      String curr = notation[i];
      //判断当前元素是运算符还是操作数
      switch (curr) {
        //如果为运算符,则从栈中弹出两个操作数,完成计算后,再次将结果压入栈中
        case "+": {
          Integer number1 = operans.pop();
          Integer number2 = operans.pop();
          Integer result = number1 + number2;
          operans.push(result);
          break;
        }
        case "-": {
          Integer number1 = operans.pop();
          Integer number2 = operans.pop();
          Integer result = number2 - number1;
          operans.push(result);
          break;
        }
        case "*": {
          Integer number1 = operans.pop();
          Integer number2 = operans.pop();
          Integer result = number1 * number2;
          operans.push(result);
          break;
        }
        case "/": {
          Integer number1 = operans.pop();
          Integer number2 = operans.pop();
          Integer result = number2 / number1;
          operans.push(result);
          break;
        }
        default: {
          operans.push(Integer.parseInt(curr));
          break;
        }
      }
    }
    //如果遍历完了,弹出栈中最后的那一个结果即可
    return operans.pop();
  }
}
