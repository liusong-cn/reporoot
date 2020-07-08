package algorithm.linked;

import java.util.Iterator;

/**
 * @author: ls
 * @date: 2020/6/19 0019 09:32
 */
public class Queue<T> implements Iterable<T>{

    private int N;

    private Node head;

    private Node last;

    public Queue(){
        head = new Node(null,null);
        last = null;
        N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void enQueue(T item){
        if(last == null){
            Node newNode = new Node(item,null);
            head.next = newNode;
            last = newNode;
        }else {
            Node oldLast = last;
            Node node = new Node(item,null);
            oldLast.next = node;
            last = node;
        }
        N++;
    }

    public T dequeue(){
        if(isEmpty())
            return null;
        Node node = head.next;
        head.next = node.next;
        N--;
        if(isEmpty()){
            last = null;
        }
        return node.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator{

        private Node node;

        public QIterator(){
            node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }

    private class Node{

        T item;

        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enQueue("a");
        q.enQueue("b");
        q.enQueue("c");
//        System.out.println(q.dequeue());
        for (String s : q) {
            System.out.println(s);
        }
    }

}
