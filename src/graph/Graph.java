package graph;

import linear.Queue;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/10 16:39
 */
public class Graph {

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
   * 创建一个包含V个顶点但不包含边的图
   */
  public Graph(int V) {
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
   * 向图中添加一条边v-w
   */
  public void addEdge(int v, int w) {
    //在无向图中,边是没有方向的,所以该边可以是v-w,也可以是w-v
    adj[v].enqueue(w);
    adj[w].enqueue(v);
    //边的数量+1
    E++;
  }

  /**
   * 获取和顶点v相邻的所有顶点
   */
  public Queue<Integer> adj(int v) {
    return adj[v];
  }
}
