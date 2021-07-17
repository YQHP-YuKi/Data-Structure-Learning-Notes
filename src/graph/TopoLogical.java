package graph;

import linear.Stack;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/07/17 16:30
 */
public class TopoLogical {

  /**
   * 顶点的拓扑排序
   */
  private Stack<Integer> order;

  /**
   * 构造拓扑排序对象
   */
  public TopoLogical(Digraph G) {
    //创建检测有向环的对象
    DirectedCycle cycle = new DirectedCycle(G);
    //判断G图中是否有环,如果没有环,则进行顶点排序
    if (!cycle.hasCycle()) {
      DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
      order = depthFirstOrder.reversePost();
    }
  }

  /**
   * 判断图G是否有环
   */
  private boolean isCycle() {
    //如果有环,order不会排序,则会默认为null
    return order == null;
  }

  /**
   * 获取拓扑排序的所有顶点
   */
  public Stack<Integer> order() {
    return order;
  }
}
