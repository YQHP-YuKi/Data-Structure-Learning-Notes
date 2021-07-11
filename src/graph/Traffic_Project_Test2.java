package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/11 17:49
 */
public class Traffic_Project_Test2 {

  public static void main(String[] args) throws Exception {
    //构建一个缓冲读取流BufferedReader
    BufferedReader br =
        new BufferedReader(new InputStreamReader(Traffic_Project_Test2.class.getClassLoader()
            .getResourceAsStream("traffic_project.txt")));
    //读取第一行数据20
    int totalNumber = Integer.parseInt(br.readLine());
    //构建一个Graph对象,大小为20
    Graph G = new Graph(totalNumber);
    //读取第二行数据7
    int secondNumber = Integer.parseInt(br.readLine());
    //循环读取7次已经连接好的城市
    for (int i = 1; i <= secondNumber; i++) {
      //例如"0 1"
      String road = br.readLine();
      String[] s = road.split(" ");
      int v = Integer.parseInt(s[0]);
      int w = Integer.parseInt(s[1]);
      //调用Graph的addEdge方法,把边添加到图中,表示已经连接好的城市
      G.addEdge(v, w);
    }
    //构建一个深度(广度)优先搜索对象,起点城市设置为9
    BreadthFirstSearch search9 = new BreadthFirstSearch(G, 9);
    //调用一个marked方法,判断8顶点和10顶点是否与起点9相通
    System.out.println("顶点8与顶点9是否相通" + search9.marked(8));
    System.out.println("顶点10与顶点9是否相通" + search9.marked(10));
  }
}
