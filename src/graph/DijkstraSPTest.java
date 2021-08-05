package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import linear.Queue;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/08/05 9:22
 */
public class DijkstraSPTest {

  public static void main(String[] args) throws Exception {
    //创建一幅加权有向图
    BufferedReader br = new BufferedReader(new InputStreamReader(
        DijkstraSPTest.class.getClassLoader().getResourceAsStream("min_route_test.txt")));
    int total = Integer.parseInt(br.readLine());
    EdgeWeightedDigraph G = new EdgeWeightedDigraph(total);
    int edgeNumbers = Integer.parseInt(br.readLine());
    for (int i = 1; i <= edgeNumbers; i++) {
      //4 5 0.35
      String line = br.readLine();
      String[] strs = line.split(" ");
      int v = Integer.parseInt(strs[0]);
      int w = Integer.parseInt(strs[1]);
      double weight = Double.parseDouble(strs[2]);
      DirectedEdge e = new DirectedEdge(v, w, weight);
      G.addEdge(e);
    }
    //创建DijkstraSP对象,查找最短路径树
    DijkstraSP sp = new DijkstraSP(G, 0);
    //查找最短路径,0->6的最短路径
    Queue<DirectedEdge> edges = sp.pathTo(6);
    //遍历打印
    for (DirectedEdge edge : edges) {
      System.out.println(edge.from() + "-->" + edge.to() + ": :" + edge.weight());
    }
  }
}
