package graph;

import linear.Queue;
import priority.MinPriorityQueue;
import uf.UF_Tree_Weighted;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/08/03 9:34
 */
public class KruskalMST {

  /**
   * 保存最小生成树的所有边
   */
  private Queue<Edge> mst;
  /**
   * 索引代表顶点,使用uf.connect(v,w)可以判断顶点v和顶点w是否在同一棵树中,使用uf.union(v,w)可以把顶点v所在的树和顶点w所在的树合并
   */
  private UF_Tree_Weighted uf;
  /**
   * 存储图中所有的边,使用最小优先队列,对边按照权重进行排列
   */
  private MinPriorityQueue<Edge> pq;

  /**
   * 根据一副加权无向图,创建最小生成树计算对象
   */
  public KruskalMST(EdgeWeightedGraph G) {
    //初始化mst
    this.mst = new Queue<Edge>();
    //初始化uf
    this.uf = new UF_Tree_Weighted(G.V());
    //初始化pq
    this.pq = new MinPriorityQueue<>(G.E());
    //把图中所有的边存储到pq中
    for (Edge e : G.edges()) {
      pq.insert(e);
    }
    //遍历pq队列,拿到最小权重的边进行处理,因为边数永远小于顶点数-1
    while (!pq.isEmpty() && mst.size() < G.V() - 1) {
      //找到权重最小的边
      Edge e = pq.delMin();
      //找到该边的两个顶点
      int v = e.either();
      int w = e.other(v);
      //判断这两个顶点是否已经在同一个树中,如果在同一个树中,如果不在同一个树中,则将这两个顶点所属的同一棵树合并为一棵树
      if (uf.connected(v, w)) {
        continue;
      }
      uf.union(v, w);
      //让边e进入到mst队列中
      mst.enqueue(e);
    }
  }

  /**
   * 获取最小生成树的所有边
   */
  public Queue<Edge> edges() {
    return mst;
  }
}
