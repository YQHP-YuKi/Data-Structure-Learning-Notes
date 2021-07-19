package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import linear.Queue;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/19 16:25
 */
public class PrimMSTTest {

  public static void main(String[] args) throws Exception {
    //准备一副加权无向图
    BufferedReader br = new BufferedReader(new InputStreamReader(
        PrimMSTTest.class.getClassLoader().getResourceAsStream("min_create_tree_test.txt")));
    //创建一个PrimMSTTest对象,计算加权无向图中最小生成树
    int total = Integer.parseInt(br.readLine());
    EdgeWeightedGraph G = new EdgeWeightedGraph(total);
    int edgeNumbers = Integer.parseInt(br.readLine());
    for (int i = 0; i < edgeNumbers; i++) {
      //格式为4 5 0.35
      String line = br.readLine();
      String[] s = line.split(" ");
      int v = Integer.parseInt(s[0]);
      int w = Integer.parseInt(s[1]);
      double weight = Double.parseDouble(s[2]);
      //构建加权无向边
      Edge edge = new Edge(v, w, weight);
      G.addEdge(edge);
    }
    //获取最小生成树中的所有边
    PrimMST primMST = new PrimMST(G);
    Queue<Edge> Edges = primMST.edges();
    //打印所有边即可
    for (Edge e : Edges) {
      int v = e.either();
      int w = e.other(v);
      double weight = e.weight();
      System.out.println(v + "-" + w + "::" + weight);
    }
  }
}
