package uf;

import java.util.Scanner;
import javax.sound.midi.Soundbank;

/**
 * @author YQHP-YuKi
 * @create 2021-07-01 17:55
 */
public class UFTest {

  public static void main(String[] args) {
    //创建并查集对象
    UF uf = new UF(5);
    System.out.println("默认情况下,并查集有的组数:" + uf.count());
    //从控制台录入两个要合并的元素,调用union方法进行合并,观察合并后并查集中的分组是否变少
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("请输入第一个要合并的元素:");
      int p = sc.nextInt();
      System.out.println("请输入第二个要合并的元素");
      int q = sc.nextInt();
      //判断这两个元素是否已经在同一组了
      if (uf.connected(p, q)) {
        System.out.println(p + "元素和" + q + "已经在同一组了");
        continue;
      } else {
        uf.union(p, q);
        System.out.println("当前并查集的组的个数:" + uf.count());
      }
    }
  }
}
