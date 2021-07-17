package graph;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/15 10:40
 */
public class DirectedCycle {

  /**
   * 索引代表顶点,值表示当前顶点是否已经被搜索
   */
  private boolean[] marked;
  /**
   * 记录图中是否有环
   */
  private boolean hasCycle;
  /**
   * 索引代表顶点,使用栈的思想,记录当前顶点有没有已经处于正在搜多的有向路径上
   */
  private boolean[] onStack;

  /**
   * 创建一个检测环对象,检测图G中是否有环
   */
  public DirectedCycle(Digraph G) {
    //初始化marked数组
    this.marked = new boolean[G.V()];
    //初始化hasCycle
    this.hasCycle = false;
    //初始化onStack数组
    this.onStack = new boolean[G.V()];
    //找到图中每一个顶点,让每一个顶点作为入口进行环的查找
    for (int v = 0; v < G.V(); v++) {
      //判断一下当前顶点有没有被搜索过,如果没被搜索过,则调用dfs进行搜索
      if (!marked[v]) {
        dfs(G, v);
      }
    }
  }

  /**
   * 基于深度优先搜索,检测图G中是否有环
   */
  private void dfs(Digraph G, int v) {
    //把当前顶点标识为已经搜索
    marked[v] = true;
    //把当前顶点进栈
    onStack[v] = true;
    //进行深度搜索
    for (Integer w : G.adj(v)) {
      //判断当前顶点w是否被搜索过,如果没有搜索过,则递归调用dfs
      if (marked[w] && w != null) {
        dfs(G, w);
      }
      //如果已经被搜索过,则判断当前顶点是否在栈stack中,如果在,则说明存在环
      if (onStack[w]) {
        hasCycle = true;
        return;
      }
    }
    //当前顶点出栈
    onStack[v] = false;
  }

  /**
   * 判断w顶点与s顶点是否相通
   */
  public boolean hasCycle() {
    return hasCycle;
  }
}
