package algorithm.tree;

/**
 * @author: ls
 * @date: 2020/7/2 0002 17:11
 * 红黑树特征：
 * 1.红链接均为左连接
 * 2.没有任何一个节点同时有两条红链接
 * 3.黑链接完美平衡，即任意一条空链接到根节点的路径红黑链接的数量都相等
 */
public class RedBlackTree<k extends Comparable<k>,v> {
    //记录根节点
    private Node node;

    //节点个数
    private int N;

    private static final boolean RED = true;

    private static final boolean BLACK = false;

//    public RedBlackTree(Node node, int n) {
//        this.node = node;
//        N = n;
//    }

    private class Node<k,V>{
        private k key;

        private v value;

        private Node left;

        private Node right;

        //用来表示指向自己的链接颜色，红色则为true,黑色为false
        private boolean color;

        public Node(k key, v value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    //判断当前节点的链接颜色
    public boolean isRed(Node x){
        //当前节点为空节点时则颜色为黑
        if(x == null)
            return false;
        return x.color == RED;
    }

    //左旋(= 左边旋转)并返回旋转后的树
    public Node rotateLeft(Node h){
        //当前节点的右子节点，且红色链接
        Node x = h.right;
        //将当前节点的右子节点设为原本右子节点的左子节点
        h.right = x.left;
        //将当前节点设为右子节点的左子节点
        x.left = h;
        //将原本右子节点的颜色设为当前节点的颜色
        x.color = h.color;
        //将当前节点的颜色设为红色
        h.color = RED;
        //返回左旋后的树，左旋后的树是原本的节点的右子节点，即x
        return x;
    }

    public Node rotateRight(Node h){
        return null;
    }

    public void flipColor(Node h){
    }

    //在树中插入
    public void put(k key, v value){}

    //在指定的树节点下插入
    public Node put(k key, v value, Node x){
        return null;
    }

    public  v getValue(k key){
        return null;
    }

    public v getValue(k key,Node x){
        return null;
    }

    public int size(){
        return N;
    }

}
