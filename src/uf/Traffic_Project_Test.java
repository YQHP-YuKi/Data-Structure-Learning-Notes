package uf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/08 20:26
 */
public class Traffic_Project_Test {

  public static void main(String[] args) throws Exception {
    //构建一个缓冲读取流BufferReader
    BufferedReader br =
        new BufferedReader(new InputStreamReader(Traffic_Project_Test.class.getClassLoader()
            .getResourceAsStream("traffic_project.txt")));
    //读取第一个行数据20
    int totalNumber = Integer.parseInt((br.readLine()));
    //构建一个并查集对象
    UF_Tree_Weighted uf_tree_weighted = new UF_Tree_Weighted(totalNumber);
    //读取第二行数据7
    int secondNumber = Integer.parseInt(br.readLine());
    //循环读取7条道路
    for (int i = 1; i <= secondNumber; i++) {
      //例如:0 1
      String line = br.readLine();
      String[] s = line.split(" ");
      //0
      int i1 = Integer.parseInt(s[0]);
      int i2 = Integer.parseInt(s[1]);
      //调用并查集对象的union方法让两个城市相通
      uf_tree_weighted.union(i1, i2);
    }
    //获取当前并查集剩余的分组数量并对其进行-1即可得到结果
    int lastRoads = uf_tree_weighted.count() - 1;
    System.out.println("还需要修建" + lastRoads + "条道路");
  }
}
