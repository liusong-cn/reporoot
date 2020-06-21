package algorithm.linked;

/**
 * @author: ls
 * @date: 2020/6/19 0019 09:32
 */
public class Queue<T> {

    private int N;

    private Node head;

    private Node last;

    public Queue(){
        head = new Node(null,null);
        N = 0;
    }

    private boolean isEmpty(){
        return N == 0;
    }

    private int size(){
        return N;
    }

    private void enQueue(T item){
        if(isEmpty()){
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

    private T dequeue(){
        if(isEmpty())
            return null;
        Node node = head.next;
        head.next = node.next;
        N--;
        return node.item;
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
        System.out.println(q.dequeue());
    }

}
