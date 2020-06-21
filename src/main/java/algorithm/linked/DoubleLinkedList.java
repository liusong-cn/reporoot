package algorithm.linked;

import java.util.Iterator;

/**
 * @author: ls
 * @date: 2020/6/16 0016 19:32
 * 双端链表
 */
public class DoubleLinkedList<T> implements Iterable<T>{

    //总长度
    private int N;
    //头节点
    private Node head;

    //尾节点
    private Node last;

    //初始化
    public DoubleLinkedList() {
        N = 0;
        head = new Node(null,null,null);
        last = null;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void clear(){
        N = 0;
        last = null;
        head.next = last;
        head.pre = null;
        head.data = null;
    }

    public int length(){
        return N;
    }

    public T get(int i){
        if(i >= N || i < 0)
            throw new RuntimeException("查找位置非法");
        Node node = head.next;
        //每一次循环得到当前节点的下一个节点
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node.data;
    }

    public void insert(T t){
        //last为null，表明没有节点
        if(last == null){
            Node node = new Node(t,head,null);
            head.next = node;
            last = node;
        }else {
            Node oldLast = last;
            Node node = new Node(t,oldLast,null);
            //oldLast的下一个节点为最新的node
            oldLast.next = node;
            //新的节点是last
            last = node;
        }
        N++;
    }

    public void insert(T t, int i){
        if(i < 0 || i>= N)
            throw new RuntimeException("插入位置异常");
        Node node = head;
        //找到i-1位置的节点
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        //i位置节点，由于i最大为N-1，插入的节点最大的位置为N-2，因为是在i前方插入，因此插入的节点不可能是
        //尾节点，因此不用维护尾节点
        Node cur = node.next;
        Node newNode = new Node(t,node,cur);
        node.next = newNode;
        cur.pre = newNode;
        N++;


    }

    public T remove(int i){
        if(i < 0 || i>= N)
            throw new RuntimeException("位置超出范围");
        Node node = head;
        //找到i-1位置的节点
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        //i位置节点
        Node cur = node.next;
        //修改指向
        //需要确定i是否是last节点,教程错误，此判断必须
        if(i == N-1){
            node.next = null;
            last = node;
        }else {
            node.next = cur.next;
            cur.next.pre = node;

        }
        N--;
        return cur.data;
    }

    public int indexOf(T t){
        Node node = head;
        //每次循环得到第i个节点
        for (int i = 0; i < N; i++) {
            node = node.next;
            if(node.data.equals(t))
                return i;
        }
        return -1;
    }

    public T getFirst(){
        //先做非空判断
        if(isEmpty())
            return null;
        return head.next.data;
    }

    public T getLast(){
        if(isEmpty())
            return null;
        return last.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new DIterator();
    }

    private class DIterator implements Iterator{

        Node node;

        public DIterator(){
            node = head;
        }

        @Override
        public boolean hasNext() {
            //只需要根据首节点依次向后寻找，有next则有下一个
            return node.next != null;
        }

        @Override
        public T next() {
            //注意返回下一个之后需要移动指针，即node的指向，否则一直循环
            Node next = node.next;
            node = next;
            return next.data;
        }
    }

    private class Node{
        T data;
        Node pre;

        Node next;

        public Node(T data,Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next  = next;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<String> d = new DoubleLinkedList<>();
        d.insert("a");
        d.insert("b");
        d.insert("c");
        d.forEach(d1 -> System.out.println(d1));
        d.remove(2);
        d.forEach(d1 -> System.out.println(d1));

//        System.out.println(d.getLast());
    }

}
