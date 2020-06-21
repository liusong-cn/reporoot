package algorithm.linked;

import java.util.Iterator;

/**
 * @author: ls
 * @date: 2020/6/16 0016 10:44
 *
 */
public class SingleLinkedList<T> implements Iterable<T>{

    //链表长度
    private int N;

    //头节点
    private Node head;

    public SingleLinkedList() {
        N = 0;
        this.head = new Node(null,null);
    }

    public void clear(){
        head.item = null;
        head.next = null;
        N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    };

    public int length(){
        return N;
    }

    public void insert(T item){
        Node newNode = new Node(null,item);
        Node preNode = head;
        //此种方式不如while条件明显
//        for (int i = 0; i < N; i++) {
//            preNode = preNode.next;
//        }
        //找到最后一个节点
        while (preNode.next != null){
            preNode = preNode.next;
        }
        preNode.next = newNode;
        N++;
    }

    public void insert(T item ,int i){
        if(i < 0 || i > N -1){
            throw new RuntimeException("插入位置不合法");
        }
        Node preNode = head;
        //头结点不算真正的节点，获取i-1节点
        for (int j = 0; j < i; j++) {
            preNode = preNode.next;
        }
        //i节点
        Node cur = preNode.next;
        Node newNode = new Node(cur,item);
        preNode.next = newNode;
        N++;
    }

    public T get(int i){
        if(i >= N || i <0)
            throw new RuntimeException("查询位置异常");
        Node node = head.next;
        //第i-1次循环获得了i位置的节点
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        return node.item;
    }

    //查询某元素第一次出现的索引
    public int indexOf(T t){
        Node node = head.next;
        //从第一个节点开始查找，找到了则返回索引
        for (int i = 0; i < N; i++) {
            if(node.item.equals(t))
                return i;
        }
        return -1;
    }

    public T remove(int i){
        if(i < 0 || i>= N)
            throw new RuntimeException("移除的位置非法");
        Node node = head;
        //查找i-1位置的节点
        for (int j = 0; j < i; j++) {
            node = node.next;
        }
        //i节点
        Node cur = node.next;
        //i节点的下一个节点
        Node ne = cur.next;
        node.next = ne;
        N--;
        return cur.item;
    }

    //翻转链表
    public void reverse(){
        if(isEmpty())
            return;
        //从第一个元素开始反转
        reverse(head.next);
    }

    /**
     * 翻转当前元素
     * @param cur 当前元素
     * @return 返回当前元素反转后的元素
     */
    public Node reverse(Node cur){
        //设置边界条件，递归的边界
        //如果当前元素没有下一个节点，那么表明该元素是未反转前链表中最后一个元素
        if(cur.next == null){
            //反转的最后将head的下一个指向该元素
            head.next = cur;
            return cur;
        }
        //如果当前元素不是最后一个，那么先反转原链表的下一个元素，作为反转后链表的上一个元素
        Node pre = reverse(cur.next);
        pre.next = cur;
        //将当前节点的下一个元素设置为null
        cur.next = null;
        return cur;
    }



    private class Node{

        //设置访问权限为同包，下一个节点
        Node next;

        //存储数据
        T item;

        public Node(Node next, T item) {
            this.next = next;
            this.item = item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        //当前索引
        int cursor = 0;


        //和课本实现方式不同，此处通过定义一个索引cursor，来定位链表中的节点
        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public T next() {
            T t = get(cursor);
            cursor++;
            return t;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<String> s = new SingleLinkedList<>();
        s.insert("a");
        s.insert("b");
        s.insert("c");
        System.out.println("a出现的位置：" + s.indexOf("a"));
        s.insert("d",1);
        s.remove(2);
        for (String s1 : s) {
            System.out.println(s1);
        }

        System.out.println("-------------");
        s.reverse();
        s.forEach(s1 -> System.out.println(s1));
    }
}
