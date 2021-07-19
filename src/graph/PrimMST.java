package graph;

import linear.Queue;
import priority.IndexMinPriorityQueue;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/19 11:24
 */
public class PrimMST {

  /**
   * 索引代表顶点,值表示当前顶点和最小生成树之间的最短边
   */
  private Edge[] edgeTo;
  /**
   * 索引代表顶点,值表示当前顶点和最小生成树之间的最短边的权重
   */
  private double[] distTo;
  /**
   * 索引代表顶点,如果当前顶点已经在树中,则值为true,否则为false
   */
  private boolean[] marked;
  /**
   * 存放树中顶点与非树中顶点之间的有效横切边
   */
  private IndexMinPriorityQueue<Double> pq;

  /**
   * 根据一副加权无向图,创建最小生成树计算对象
   */
  public PrimMST(EdgeWeightedGraph G) {
    //初始化edgeTo
    this.edgeTo = new Edge[G.V()];
    //初始化distTo
    this.distTo = new double[G.V()];
    for (int i = 0; i < distTo.length; i++) {
      distTo[i] = Double.POSITIVE_INFINITY;
    }
    //初始化marked
    this.marked = new boolean[G.V()];
    //初始化pq
    pq = new IndexMinPriorityQueue<Double>(G.V());
    //默认让顶点0第一个进入到树中,因为0是第一个进入,没有与其他顶点通过边相连,所以让distTo对应位置的值存储0.0
    distTo[0] = 0.0;
    pq.insert(0, 0.0);
    //遍历索引最小优先队列,拿到最小横切边对应的顶点,把该顶点加入到最小生成树中
    while (!pq.isEmpty()) {
      visit(G, pq.delMin());
    }
  }

  /**
   * 将顶点v添加到最小生成树中,并且更新数据
   */
  private void visit(EdgeWeightedGraph G, int v) {
    //把顶点v添加到最小生成树中
    marked[v] = true;
    //更新数据
    for (Edge e : G.adj(v)) {
      //获取v顶点的另外一个顶点
      int w = e.other(v);
      //判断顶点w是否在树中,如果不在树中,更新数据,如果在树中,则无需处理
      if (marked[w]) {
        continue;
      } else {
        //判断边e的权重是否小于树中已经存在的最小边的权重
        //个人理解就是,最开始是0-7,让后让连接7的所有顶点,只要比0-7小,就更新数据,从而找到了最小横切边
        if (e.weight() < distTo[w]) {
          //更新数据
          edgeTo[w] = e;
          distTo[w] = e.weight();
          //如果pq中存储了有效横切边已经包含了w顶点,则需要修正最小索引优先队列w索引相关联的权重
          if (pq.contains(w)) {
            pq.changeItem(w, e.weight());
          } else {
            //如果有效横切边不包含w顶点,则直接向最小索引优先队列中添加v-w和其权重值
            pq.insert(w, e.weight());
          }
        }
      }
    }
  }

  /**
   * 获取最小生成树的所有边
   */
  public Queue<Edge> edges() {
    //创建队列对象
    Queue<Edge> allEdges = new Queue<>();
    //遍历edgeTo数组,如果不为null,则添加到allEdges中
    for (int i = 0; i < edgeTo.length; i++) {
      if (edgeTo[i] != null) {
        allEdges.enqueue(edgeTo[i]);
      }
    }
    return allEdges;
  }
}
