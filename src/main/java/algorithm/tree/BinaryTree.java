package algorithm.tree;

import algorithm.linked.Queue;

/**
 * @author: ls
 * @date: 2020/6/21 0021 10:02
 * 二叉树
 * 二叉树总体概念每个节点最多有两个子节点，左子节点小于父节点，右子节点大于父节点
 * 满二叉树：除叶子节点外每个节点都是两个子节点
 * 完全二叉树：叶子节点只能出现先最下层和次下层，并且最下层节点只能出现在左侧树的若干节点上
 */
public class BinaryTree<K extends Comparable<K>,V> {

    //节点个数
    private int N;

    //根节点，由此找到其他节点
    private Node root;

    public BinaryTree() {
        N = 0;
    }

    public void put(K key, V value){
        root = put(root,key,value);
    }

    //返回插入后的子树
    public Node put(Node node,K key, V value){
        //如果当前没有节点，则作为根节点
        if(node == null){
            node = new Node(key,value,null,null);
            N++;
            return node;
        }
        //如果有节点，则从根节点开始向下插入

        //如果当前key大于node.key,则继续向右子节点查找
        int cmp = key.compareTo((K) node.key);
        if(cmp>0){
            node.right = put(node.right,key,value);
        }else if(cmp <0){
            //如果当前key小于node.key,则继续向左子节点查找
            node.left = put(node.left,key,value);
        }else {
            //如果当前key等于node.key,则替换node
            node.value = value;
        }
        return node;
    }

    public V get(K key){

        return get(root,key);
    }

    //返回当前子树中的对应value
    public V get(Node node,K key){
        if(node == null)
            return null;
        int cmp = key.compareTo((K) node.key);
        if(cmp>0){
            //当前key大于node.key.说明在右边
            return (V) get(node.right,key);
        }else if (cmp < 0){
            //当前key小于node.key.说明在左边
            return (V) get(node.left,key);
        }else {
            return (V) node.value;
        }
    }

    public void delete(K key){
        delete(root,key);
    }

    //删除并返回删除后的子树
    public Node delete(Node node ,K key){
        if(node == null)
            return null;
        int cmp = key.compareTo((K) node.key);
        if(cmp>0){
            node.right = delete(node.right,key);
        }else if(cmp<0){
            node.left = delete(node.left,key);
        }else {
            N--;
            //当需要删除当前节点时，需要返回其子树，判断子树是否存在
            //右子树不存在,返回左子树
            if(node.right == null){
                return node.left;
            }
            //左子树不存在,返回右子树
            if(node.left == null){
                return node.right;
            }
            //子树存在时，找到子树的右子树中最小的节点，将其替换当前节点,删除其原本位置，并挂接当前节点的左右子树
            Node minNode = node.right;
            while (minNode.left != null){
                minNode = minNode.left;
            }
            //删除最小节点
            Node n = node.right;
            while (n.left != null){
                //如果当前节点的左左子节点为空，说明当前节点的子节点就是最小节点,删除它
                if(n.left.left == null){
                    n.left = null;
                }else {
                    //否则逐级向下找到该节点
                    n  = n.left;
                }
            }
            minNode.left = node.left;
            minNode.right = node.right;
            if(node == root){
                root = minNode;
            }else {
                //让最小值替换当前节点
                node = minNode;

            }




        }
        return node;
    }

    public int size(){
        return N;
    }



    private class Node<K,V> {

        public K key;

        V value;

        public Node left;

        public Node right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }


    }

    //遍历方式根据是否先查找根节点，再查找左子树和右子树而不同，分为
    //前序遍历：根节点，左子树，右子树
    //中序遍历：左子树，根节点，右节点
    //后序遍历：左子树，右子树，根节点
    public Queue<K> preErgodic(){
        Queue<K> keys = new Queue<>();
        preErgodic(root,keys);
        return keys;
    }

    public void preErgodic(Node node,Queue<K> queue){
        if(node == null)
            return;
        queue.enQueue((K) node.key);
        if(node.left != null){
            preErgodic(node.left,queue);
        }
        if(node.right != null){
            preErgodic(node.right,queue);
        }
    }

    public void preErgodic1(Node cur){
        if(cur != null){
            System.out.println("key:" + cur.key + ",value:" + cur.value);
            preErgodic1(cur.left);
            preErgodic1(cur.right);
        }
    }


    public static void main(String[] args) {
        BinaryTree<Integer,String> b = new BinaryTree<>();
        b.put(10,"a");
        b.put(2,"b");
        b.put(3,"c");
        b.put(1,"f");
        b.put(12,"d");
        b.put(15,"e");
        b.put(11,"g");
        b.delete(12);
//        System.out.println(b.get(3));
//        System.out.println(b.size());
//        Queue<Integer> keys = b.preErgodic();
//        for (int i = 0; i < 7; i++) {
//            System.out.println(b.get(keys.dequeue()));
//        }
//        System.out.println(b.get(10));
        b.preErgodic1(b.root);

    }

}
