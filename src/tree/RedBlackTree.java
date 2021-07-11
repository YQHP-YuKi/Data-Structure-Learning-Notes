package tree;


/**
 * @author YQHP-YuKi
 * @create 2021-06-22 11:06
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {

  /**
   * 根节点
   */
  private Node root;
  /**
   * 记录树中元素的个数
   */
  private int N;
  /**
   * 红色链接
   */
  private static final boolean Red = true;
  /**
   * 黑色链接
   */
  private static final boolean Black = false;

  /**
   * 节点类
   */
  private class Node {

    //存储键
    public Key key;
    //存储值
    public Value value;
    //记录左子节点
    public Node left;
    //记录右子节点
    public Node right;
    //由其父节点指向它的链接的颜色
    public boolean color;

    public Node(Key key, Value value, Node left, Node right, boolean color) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
      this.color = color;
    }
  }

  /**
   * 判断当前节点的父指向链接是否为红色
   */
  private boolean isRed(Node x) {
    //如果x是空链接,则应该是黑色
    if (x == null) {
      return false;
    }
    return x.color == Red;
  }

  /**
   * 左旋调整
   */
  private Node rotateLeft(Node h) {
    //获取h的右子节点x
    Node x = h.right;
    //让x的左子节点变为h的右子节点
    h.right = x.left;
    //让h变为x的左子节点
    x.left = h;
    //让x的color属性等于h节点的color属性
    x.color = h.color;
    //让h节点的color属性变为red
    h.color = Red;
    return x;
  }

  /**
   * 右旋调整
   */
  private Node rotateRight(Node h) {
    //获取h节点的左子节点x
    Node x = h.left;
    //让x的右子节点称为h节点的左子节点
    h.left = x.right;
    //让h节点成为x的右子节点
    x.right = h;
    //让x节点的color属性变为h节点的color属性
    h.color = x.color;
    //让h节点的color属性变为red
    h.color = Red;
    return x;
  }

  /**
   * 颜色反转,相当于完成拆分4-节点
   */
  private void flipColors(Node h) {
    //让当前节点color变为red
    h.color = Red;
    //左子节点和右子节点变为black
    h.left.color = Black;
    h.right.color = Black;
  }

  /**
   * 在整个树上完成插入操作
   */
  public void put(Key key, Value value) {
    root = put(root, key, value);
    //根节点的颜色永远是黑色的
    root.color = Black;
  }

  /**
   * 在指定树中,完成插入操作,并返回添加元素后的新的树
   */
  private Node put(Node h, Key key, Value value) {
    //判断h是否为空,如果为空,直接返回一个red的节点即可
    if (h == null) {
      //数量+1
      N++;
      return new Node(key, value, null, null, Red);
    }
    //比较h节点的键和key的大小
    int cmp = key.compareTo(h.key);
    //如果比key小
    if (cmp < 0) {
      //继续往左
      h.left = put(h.left, key, value);
    }//如果大于key
    else if (cmp > 0) {
      //继续往右
      h.right = put(h.right, key, value);
    }//如果在中间范围
    else {
      //进行值的替换
      h.value = value;
    }
    //进行左旋判断:当前节点的左子节点为black,右子节点为red
    if (!isRed(h.left) && isRed(h.right)) {
      h = rotateLeft(h);
    }
    //进行右旋判断:当前节点左子节点为red,左子节点的左子节点为red
    if (isRed(h.left) && isRed(h.left.left)) {
      h = rotateRight(h);
    }
    //进行颜色反转判断,当前节点的左子节点为red,右子节点为red
    if (isRed(h.left) && isRed(h.right)) {
      flipColors(h);
    }
    return h;
  }

  /**
   * 根据key,从树中找出对应的值
   */
  public Value get(Key key) {
    return get(root, key);
  }

  /**
   * 从指定的树x中,找出key对应的值
   */
  private Value get(Node x, Key key) {
    if (x == null) {
      return null;
    }
    //比较x节点的键和key的大小
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      return get(x.left, key);
    } else if (cmp > 0) {
      return get(x.right, key);
    } else {
      return x.value;
    }
  }

  /**
   * 获取树中元素的个数
   */
  public int size() {
    return N;
  }
}
