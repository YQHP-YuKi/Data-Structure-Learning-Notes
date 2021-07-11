package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author YQHP-YuKi
 * @create 2021-03-27 11:38
 */
public class SortCompare {
  //调用不同的测试方法完成测试

  public static void main(String[] args) throws Exception {
    //创建一个Arraylist集合,保存IO读取到的整数数据
    ArrayList<Integer> list = new ArrayList<>();

    //创建BufferedReader,读取数据,并存储到ArrayList中

    BufferedReader reader =
        new BufferedReader(
            new InputStreamReader(SortCompare.class.getClassLoader().getResourceAsStream(
                "reverse_arr.txt")));
    String line = null;
    while ((line = reader.readLine()) != null) {
      //line是字符串,我们需要转化成Integer的形式,才能存储到集合中
      int i = Integer.parseInt(line);
      list.add(i);
    }
    reader.close();
    //把ArrayList集合转换为数组
    Integer[] a = new Integer[list.size()];
    list.toArray(a);
    //调用测试代码
//    testinsert(a);
    //插入排序的时间23458毫秒
//    testshell(a);
    //希尔排序执行的时间18毫秒
    testMerge(a);
  }

  //测试希尔排序

  public static void testshell(Integer[] a) {
    long start = System.currentTimeMillis();
    Shell.sort(a);
    long end = System.currentTimeMillis();
    System.out.println("希尔排序执行的时间" + (end - start) + "毫秒");
  }

  //测试插入排序

  public static void testinsert(Integer[] a) {
    long start = System.currentTimeMillis();
    Insertion.sort(a);
    long end = System.currentTimeMillis();
    System.out.println("插入排序的时间" + (end - start) + "毫秒");
  }

  //测试归并排序

  public static void testMerge(Integer[] a) {
    long start = System.currentTimeMillis();
    Merge.sort(a);
    long end = System.currentTimeMillis();
    System.out.println("归并排序执行的时间" + (end - start) + "毫秒");
  }
}
