package symbol;


/**
 * @author YQHP-YuKi
 * @create 2021-05-29 12:01
 */
public class OrderSymbolTableTest {

  public static void main(String[] args) {
    //创建有序符号表对象
    OrderSymbolTable<Integer, String> OrderTable = new OrderSymbolTable<>();
    OrderTable.put(1,"正义高达");
    OrderTable.put(2,"自由高达");
    OrderTable.put(4,"菲尼克斯3号机");
    OrderTable.put(8,"扎古");

    OrderTable.put(3,"队长!!!");
  }
}
