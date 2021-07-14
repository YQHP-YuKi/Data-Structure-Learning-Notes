package graph;

import java.io.PushbackInputStream;
import linear.Stack;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/14 16:11
 */
public class DepthFirstPaths {

  /**
   * 索引代表顶点,值表示当前顶点是否已经被搜索
   */
  private boolean[] marked;
  /**
   * 起点
   */
  private int s;
  /**
   * 索引代表顶点,值代表从起点s到当前顶点路径上的最后一个顶点
   */
  private int[] edgeTo;

  /**
   * 构造深度优先搜索对象,使用深度优先搜索找出G图中起点为s的所有路径
   */
  public DepthFirstPaths(Graph G, int s) {
    //初始化marked数组
    this.marked = new boolean[G.V()];
    //初始化起点s
    this.s = s;
    //初始化edgeTo数组
    this.edgeTo = new int[G.V()];
    dfs(G, s);
  }

  /**
   * 使用深度搜索优先搜索找出G图中v顶点的所有相邻顶点
   */
  private void dfs(Graph g, int v) {
    //把v标识为已经搜索
    marked[v] = true;
    //遍历顶点v的邻接表,拿到每一个相通的顶点,继续递归搜索
    for (Integer w : g.adj(v)) {
      //如果顶点w没有被搜索,则继续搜索
      if (marked[w] == false) {
        //因为是从v到w,所以edgeTo[w]的值要为v
        edgeTo[w] = v;
        dfs(g, w);
      }
    }
  }

  /**
   * 判断w顶点与s顶点是否存在路径
   */
  public boolean hasPathTo(int v) {
    return marked[v];
  }

  /**
   * 找出从起点s到顶点v的路径(就是该路径经过的顶点)
   */
  public Stack<Integer> pathTo(int v) {
    //先判断是否有路径
    if (!hasPathTo(v)) {
      //如果没有路径
      return null;
    }
    //如果有路径,则应该先创建一个栈对象,保存路径中的所有顶点,又因为是倒着存进去的,所以用栈而不用堆
    Stack<Integer> path = new Stack<>();
    //通过循环,从顶点v开始找直到找到起点s为止
    while (v != s) {
      path.push(v);
      v = edgeTo[v];
    }
    //把起点s放入到栈中
    path.push(s);
    return path;
  }
}
