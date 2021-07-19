package graph;

import linear.Queue;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/18 11:45
 */
public class EdgeWeightedGraph {

  /**
   * 顶点总数
   */
  private final int V;
  /**
   * 边的总数
   */
  private int E;
  /**
   * 邻接表
   */
  private Queue<Edge>[] adj;

  /**
   * 创建一个含有V个顶点的空加权无向图
   */
  public EdgeWeightedGraph(int V) {
    //初始化顶点的数量
    this.V = V;
    //初始化边的数量
    this.E = 0;
    //初始化邻接表
    this.adj = new Queue[V];
    for (int i = 0; i < adj.length; i++) {
      adj[i] = new Queue<Edge>();
    }
  }

  /**
   * 获取图中顶点的数量
   */
  public int V() {
    return V;
  }

  /**
   * 获取图中边的数量
   */
  public int E() {
    return E;
  }

  /**
   * 向加权无向图中添加一条边e
   */
  public void addEdge(Edge e) {
    //需要让e同时出现在e的两个顶点的邻接表中
    int v = e.either();
    int w = e.other(v);
    adj[v].enqueue(e);
    adj[w].enqueue(e);
    //边的数目+1
    E++;
  }

  /**
   * 获取和顶点v相关的所有边
   */
  public Queue<Edge> adj(int v) {
    return adj[v];
  }

  /**
   * 获取加权无向图的所有边
   */
  public Queue<Edge> edges() {
    //创建一个队列对象来存储所有的边
    Queue<Edge> allEdges = new Queue<>();
    //遍历图中的每一个顶点,找到该顶点的邻接表,邻接表中存储了该顶点关联的所有边
    //但需要注意的是,因为是无向图,所以1-->2==2-->1,所以我们需要判断该边是否找到了2次
    for (int i = 0; i < V; i++) {
      //遍历i顶点的邻接表,这里的adj是adj方法而非adj变量,其实用adj[i]也可,因为adj方法也是返回adj[i]
      for (Edge e : adj(i)) {
        //如果另外个顶点大于当前顶点,则添加
        if (e.other(i) < i) {
          allEdges.enqueue(e);
        }
      }
    }
    return allEdges;
  }
}
