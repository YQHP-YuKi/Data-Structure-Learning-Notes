package uf;

/**
 * @author YQHP-YuKi
 * @create 2021-07-02 10:30
 */
public class UF_Tree {

  /**
   * 记录节点元素和该元素所在分组的标识
   */
  private int[] eleAndGroup;
  /**
   * 记录并查集中数据的分组个数
   */
  private int count;

  /**
   * 初始化并查集
   */
  public UF_Tree(int N) {
    //初始化分组的数量,默认情况下有N个分组
    this.count = N;
    //初始化eleAndGroup数组
    this.eleAndGroup = new int[N];
    //初始化eleAndGroup中的元素及其所在的组的标识符,让eleAndGroup数组的索引作为并查集的每个节点的元素
    for (int i = 0; i < eleAndGroup.length; i++) {
      eleAndGroup[i] = i;
    }
  }

  /**
   * 获取当前并查集中的数据有多少个分组
   */
  public int count() {
    return count;
  }

  /**
   * 判断并查集中元素p和元素q是否在同一分组中
   */
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  /**
   * 元素p所在分组的标识符
   */
  public int find(int p) {
    while (true) {
      if (eleAndGroup[p] == p) {
        return p;
      } else {
        p = eleAndGroup[p];
      }
    }
  }

  /**
   * 把p元素所在分组和q元素所在分组合并
   */
  public void union(int p, int q) {

  }
}
