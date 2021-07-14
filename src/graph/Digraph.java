package graph;

import linear.Queue;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/14 18:15
 */
public class Digraph {

  /**
   * 顶点数目
   */
  private final int V;
  /**
   * 边的数目
   */
  private int E;
  /**
   * 邻接表
   */
  private Queue<Integer>[] adj;

  /**
   * 创建一个包含V个顶点但不包含边的有向图
   */
  public Digraph(int V) {
    //初始化顶点数量
    this.V = V;
    //初始化边的数量
    this.E = 0;
    //初始化邻接表
    this.adj = new Queue[V];
    for (int i = 0; i < adj.length; i++) {
      adj[i] = new Queue<Integer>();
    }
  }

  /**
   * 获取顶点数目
   */
  public int V() {
    return V;
  }

  /**
   * 获取边的数目
   */
  public int E() {
    return E;
  }

  /**
   * 向有向图中添加一条边v->w
   */
  public void addEdge(int v, int w) {
    //只需要让顶点w出现在顶点的邻接表中,因为边是有方向的,邻接表的含义就是:v-->其他顶点
    adj[v].enqueue(w);
    //边的数目+1
    E++;
  }

  /**
   * 获取由v指出的边所连接的所有顶点
   */
  public Queue<Integer> adj(int v) {
    return adj[v];
  }

  /**
   * 该图的反向图
   */
  private Digraph reverse() {
    //创建有向图对象
    Digraph r = new Digraph(V);
    //遍历原图中的每一个顶点
    for (int v = 0; v < V; v++) {
      //获取该顶点v所指出的所有的边w
      for (Integer w : adj[v]) {
        //再反向连接回v
        r.addEdge(w, v);
      }
    }
    return r;
  }
}
