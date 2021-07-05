package tree;

import LiKou.Solution.Node;
import java.security.Key;
import linear.Queue;

/**
 * @author YQHP-YuKi
 * @create 2021-05-30 9:44
 */

public class BinaryTree<Key extends Comparable<Key>, Value> {

  /**
   * 记录首节点
   */
  private Node root;
  /**
   * 记录树中元素的个数
   */
  public int N;

  private class Node {

    //存储键
    public Key key;
    //存储值
    private Value value;
    //记录左子节点
    public Node left;
    //记录右子节点
    public Node right;

    public Node(Key key, Value value, Node left, Node right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }

  /**
   * 获取树中元素的个数
   */
  public int size() {
    return N;
  }

  /**
   * 向树中添加元素key-value
   */
  public void put(Key key, Value value) {
    //其实要向树中插入就是向根节点中插入,所以调用put的重载方法
    root = put(root, key, value);
  }

  /**
   * 重载put方法,向指定的树中添加key-value,并返回添加元素后的新树
   */
  private Node put(Node x, Key key, Value value) {
    //如果这个树为空,则直接创建这个新树,并返回
    if (x == null) {
      //首先元素个数+1
      N++;
      //因为这是一个完全新的树,所以不指向任何一个子树
      return new Node(key, value, null, null);
    }
    //如果这个树不为空,则需要与其键进行比较
    if ((key.compareTo(x.key)) > 0) {
      //如果要插入的这个值大于原来的那个值,则插入到节点的右边
      x.right = put(x.right, key, value);
    } else if ((key.compareTo(x.key)) < 0) {
      //如果要插入的这个值小于原来的那个值,则插入到节点的左边
      x.left = put(x.left, key, value);
    } else {
      //如果要插入的这个值等于原来的那个值,则直接更新原来节点的value即可
      x.value = value;
    }
    //返回新的节点即可
    return x;
  }

  /**
   * 查询树中指定的key对应的value
   */
  public Value get(Key key) {
    //这是从整个树中寻找key,可以调用重载的方法从根节点开始寻找key
    return get(root, key);
  }

  /**
   * 从指定的树x中,查找key对应的值
   */
  public Value get(Node x, Key key) {
    //情况1:例如找key=10,但最大的key=9,相当于找9的右下节点,相当于找到了个null,所以直接返回null
    if (x == null) {
      return null;
    }
    //情况2:如果x!=null,相当于可以继续向下找,则应该判断是大于还是小于,从而判断是向左找还是向右找,直到找到key相等的键,直接返回value
    if ((key.compareTo(x.key)) > 0) {
      //如果比key大,则向右下找,使用递归方法
      return get(x.right, key);
    } else if ((key.compareTo(x.key)) < 0) {
      //如果比key小,则向左下找,使用递归方法
      return get(x.left, key);
    } else {
      //如果key相等,则返回value
      return x.value;
    }
  }

  /**
   * 删除树中key对应的value
   */
  public void delete(Key key) {
    //这是从整个树中删除某个key,所以调用重载方法即可
    delete(root, key);
  }

  /**
   * 删除指定树x中的key对应的value,并返回删除后的树
   */
  public Node delete(Node x, Key key) {
    //情况1:找不到想指定删除的x树,直接返回null
    if (x == null) {
      return null;
    }
    //情况2:能找到指定删除的x树
    if ((key.compareTo(x.key)) > 0) {
      //如果比key大,则向右下找,使用递归方法
      x.right = delete(x.right, key);
    } else if ((key.compareTo(x.key)) < 0) {
      //如果比key小,则向左下找,使用递归方法
      x.left = delete(x.left, key);
    } else {
      //元素个数-1
      N--;
      //如果key相等,则找到该x树,进行删除
      //这时候就要去找x节点的右子树的最小节点也就是最左节点
      //情况1:
      //如果右子树为空,则直接将左子树链接起来
      if (x.right == null) {
        return x.left;
      }
      //如果左子树为空,则直接将右子树链接起来
      if (x.left == null) {
        return x.right;
      }
      //情况2:
      //如果一切正常的话,就要从右边找最小
      Node minNode = x.right;
      while (minNode.left != null) {
        minNode = minNode.left;
      }
      //将minNode与他的父节点断开连接
      Node xRight = x.right;
      while (xRight.left != null) {
        if (xRight.left == minNode) {
          xRight.left = null;
        } else {
          //变换n节点
          xRight = xRight.left;
        }
      }
      //让minNode的左子树变为x的左子树
      minNode.left = x.left;
      //让minNode的右子树变为x的右子树
      minNode.right = x.right;
      //让minNode的父节点变为x的父节点
      x = minNode;
    }
    return x;
  }

  /**
   * 查找树中最小的键
   */
  public Key min() {
    return min(root).key;
  }

  /**
   * 重载方法,查找指定树x中最小键所在节点的位置
   */
  private Node min(Node x) {
    //其实就是一直向左,使用递归调用找到最小的节点
    if (x.left != null) {
      return min(x.left);
    } else {
      return x;
    }
  }

  /**
   * 查找树中最大的键
   */
  public Key max() {
    return max(root).key;
  }

  /**
   * 重载方法,查找指定树x中最大键所在节点的位置
   */
  private Node max(Node x) {
    //使用递归调用,一直向右找,直到找到最右的节点
    if (x.right != null) {
      return max(x.right);
    } else {
      return x;
    }
  }

  /**
   * 前序遍历*/
  /**
   * 获取整个树中所有的键
   */
  public Queue<Key> preErgodic() {
    Queue<Key> keys = new Queue<Key>();
    preErgodic(root, keys);
    return keys;
  }

  /**
   * 获取指定树x中的所有键,放到keys队列中
   */
  private void preErgodic(Node x, Queue<Key> keys) {
    if (x == null) {
      return;
    }
    //把x节点的key放入到keys队列中
    keys.enqueue(x.key);
    //递归遍历x节点的左子树
    if (x.left != null) {
      preErgodic(x.left, keys);
    }
    //递归遍历x节点的右子树
    if (x.right != null) {
      preErgodic(x.right, keys);
    }
  }
  /**
   * 中序遍历*/
  /**
   * 获取整个树中的所有键
   */
  public Queue<Key> midErgodic() {
    Queue<Key> keys = new Queue<>();
    midErgodic(root, keys);
    return keys;
  }

  /**
   * 获取指定树x中的所有键,放到keys队列中
   */
  private void midErgodic(Node x, Queue<Key> keys) {
    if (x == null) {
      return;
    }
    //递归遍历x节点的左子树
    if (x.left != null) {
      midErgodic(x.left, keys);
    }
    //把x节点的key放入到keys队列中
    keys.enqueue(x.key);
    //递归遍历x节点的右子树
    if (x.right != null) {
      midErgodic(x.right, keys);
    }
  }
  /**
   * 后序遍历*/
  /**
   * 获取整个树中的所有键
   */
  public Queue<Key> afterErgodic() {
    Queue<Key> keys = new Queue<>();
    afterErgodic(root, keys);
    return keys;
  }

  /**
   * 获取指定树x中的所有键,放到keys队列中
   */
  private void afterErgodic(Node x, Queue<Key> keys) {
    if (x == null) {

      return;
    }
    //递归遍历x节点的左子树
    if (x.left != null) {
      afterErgodic(x.left, keys);
    }
    //递归遍历x节点的右子树
    if (x.right != null) {
      afterErgodic(x.right, keys);
    }
    //把x节点的key放入到keys队列中
    keys.enqueue(x.key);
  }

  /**
   * 使用层序遍历,获取整个树中的所有键
   */
  public Queue<Key> layerErgodic() {
    //定义两个队列,分别存储树中的键和树中的节点
    Queue<Key> keys = new Queue<>();
    Queue<Node> nodes = new Queue<>();
    //默认往队列中放入根节点,从根节点开始找
    nodes.enqueue(root);
    //开始循环,当nodes这个队列清空时,就退出循环
    while (!nodes.isEmpty()) {
      //从nodes队列中弹出一个节点,获取当前节点的key,把key放入到keys中
      Node n = nodes.dequeue();
      keys.enqueue(n.key);
      //判断当前节点的左节点是否为空,如果不为空,把当前节点的左节点放入到nodes队列中
      if (n.left != null) {
        nodes.enqueue(n.left);
      }
      //判断当前节点的右节点是否为空,如果不为空,把当前节点的右节点放入到nodes队列中
      if (n.right != null) {
        nodes.enqueue(n.right);
      }
    }
    return keys;
  }
  /**
   * 二叉树的最大深度问题*/
  /**
   * 获取整个树的最大深度
   */
  public int maxDepth() {
    return maxDepth(root);
  }

  /**
   * 获取指定树x的最大深度
   */
  private int maxDepth(Node x) {
    //如果节点为null,则最大深度为0
    if (x == null) {
      return 0;
    }
    //定义两个变量,x左子树的最大深度,x右子树的最大深度
    int maxL = 0, maxR = 0;
    //计算x节点左子树的最大深度
    if (x.left != null) {
      maxL = maxDepth(x.left);
    }
    //计算x节点右子树的最大深度
    if (x.right != null) {
      maxR = maxDepth(x.right);
    }
    //将两个最大深度进行比较,取较大值+1并进行返回
    return maxL > maxR ? maxL + 1 : maxR + 1;
  }
}

