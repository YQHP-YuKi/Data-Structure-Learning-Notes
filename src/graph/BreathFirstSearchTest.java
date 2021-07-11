package graph;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/10 17:54
 */
public class BreathFirstSearchTest {

  public static void main(String[] args) {
    //准备一幅图Graph对象
    Graph graph = new Graph(13);
    //图1
    graph.addEdge(0, 5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(0, 6);
    graph.addEdge(5, 3);
    graph.addEdge(5, 4);
    graph.addEdge(3, 4);
    graph.addEdge(4, 6);
    //图2
    graph.addEdge(7, 8);
    //图3
    graph.addEdge(9, 11);
    graph.addEdge(9, 10);
    graph.addEdge(9, 12);
    graph.addEdge(11, 12);
    //准备广度优先搜索对象
    BreadthFirstSearch search1 = new BreadthFirstSearch(graph, 0);
    //测试与某个顶点相通的顶点数量
    int graph1count = search1.count();
    System.out.println("在图1中与0顶点相通的顶点的数量为:" + graph1count);
    //测试某个顶点与起点是否相通
    boolean marked5 = search1.marked(5);
    System.out.println("顶点5与顶点0是否相通" + marked5);
    boolean marked7 = search1.marked(7);
    System.out.println("顶点7与顶点0是否相通" + marked7);
  }
}
