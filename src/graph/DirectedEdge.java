package graph;

/**
 * Created by YQHP-YuKi.
 *
 * @author <a href="http://iamyqhp.com/">米拉桑</a>
 * @date 2021/08/03 16:18
 */
public class DirectedEdge {

  /**
   * 起点
   */
  private final int v;
  /**
   * 终点
   */
  private final int w;
  /**
   * 当前边的权重
   */
  private final double weight;

  /**
   * 通过顶点v和w,以及权重weight值构造一个边对象
   */
  public DirectedEdge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  /**
   * 获取边的权重值
   */
  public double weight() {
    return weight;
  }

  /**
   * 获取有向边的起点
   */
  public int from() {
    return v;
  }

  /**
   * 获取有向边的终点
   */
  public int to() {
    return w;
  }
}
