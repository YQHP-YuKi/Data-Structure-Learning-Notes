package symbol;

/**
 * @author YQHP-YuKi
 * @create 2021-05-29 10:14
 */
public class SymbolTableTest {

  public static void main(String[] args) {
    //创建符号表对象
    SymbolTable<Integer, String> symboltable = new SymbolTable<>();
    //测试put方法,1个是插入,1个是替换
    symboltable.put(1, "自由高达");
    symboltable.put(2, "正义高达");
    symboltable.put(3, "扎古");
    System.out.println("插入完毕后,元素的个数为:" + symboltable.size());
    //测试get方法
    System.out.println("没替换前的2号键为:" + symboltable.get(2));
    symboltable.put(2, "菲尼克斯3号机");
    System.out.println("替换后的2号键为:" + symboltable.get(2));
    //测试delete方法
    symboltable.delete(3);
    System.out.println("删除3号键后,元素的个数为:" + symboltable.size());
  }
}
