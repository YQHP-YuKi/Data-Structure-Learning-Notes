package uf;

/**
 * @author YQHP-YuKi
 * @create 2021-06-29 21:44
 */
public class UF {

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
  public UF(int N) {
    //初始化分组的数量,默认情况下初始化N个分组
    this.count = N;
    //初始化eleAndGroup数组
    this.eleAndGroup = new int[N];
    //初始化eleAndGroup中的元素及其所在组的标识符
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
   * 元素p所在分组的标识符
   */
  public int find(int p) {
    return eleAndGroup[p];
  }

  /**
   * 判断并查集中元素p和元素q是否在同一分组
   */
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  /**
   * 把p元素所在分组和q元素所在分组合并
   */
  public void union(int p, int q) {
    //判断元素p与q是否已经在同一分组中
    if (connected(p, q)) {
      //如果在在同一分组中,则直接结束方法
      return;
    } else {
      //如果不在同一分组,则将两个分组合并
      //先找到p所在分组的标识符
      int pGroup = find(p);
      //再找到q所在分组的标识符
      int qGroup = find(q);
      //合并组,让p所在组的所有元素的组标识符变为q所在分组的标识符
      for (int i = 0; i < eleAndGroup.length; i++) {
        if (eleAndGroup[i] == pGroup) {
          eleAndGroup[i] = qGroup;
        }
      }
      //分组个数-1
      this.count--;
    }
  }
}
