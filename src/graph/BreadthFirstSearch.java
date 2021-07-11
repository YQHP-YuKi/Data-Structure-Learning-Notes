package graph;

import linear.Queue;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/11 10:43
 */
public class BreadthFirstSearch {

  /**
   * 索引代表顶点,值表示当前顶点是否已经被搜索
   */
  private boolean[] marked;
  /**
   * 记录有多少个顶点与s顶点相通
   */
  private int count;
  /**
   * 用来存储待搜索邻接表的点
   */
  private Queue<Integer> waitSearch;

  /**
   * 构造广度优先搜索对象,使用广度优先搜索找出G图中s顶点的所有相邻顶点
   */
  public BreadthFirstSearch(Graph G, int s) {
    this.marked = new boolean[G.V()];
    this.count = 0;
    waitSearch = new Queue<Integer>();
    bfs(G, s);
  }

  /**
   * 使用广度优先搜素找出G图中v顶点的所有相邻顶点
   */
  private void bfs(Graph G, int v) {
    //把当前顶点v标识为已经搜索
    marked[v] = true;
    //让v进入队列
    waitSearch.enqueue(v);
    //循环调用,如果队列不为空,则从队列中弹出一个顶点
    while (!waitSearch.isEmpty()) {
      //弹出队列的顶点
      Integer wait = waitSearch.dequeue();
      //遍历wait顶点的兄弟节点
      for (Integer w : G.adj(wait)) {
        //如果没有被搜索,对其进行搜索
        if (!marked[w]) {
          marked[w] = true;
          //将节点放入到队列尾部,用于后续获得该节点的兄弟节点
          waitSearch.enqueue(w);
          //让相通的数目+1
          count++;
        }
      }
    }
  }

  /**
   * 判断w顶点与s顶点是否相通
   */
  public boolean marked(int w) {
    return marked[w];
  }

  /**
   * 获取与顶点s相通的所有顶点的总数
   */
  public int count() {
    return count;
  }
}
