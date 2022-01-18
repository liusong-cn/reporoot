package algorithm.stack_prac;

/**
 * @auther: ls
 * @date: 2022/1/17
 * @description:
 */
public class Stack<T> {

    private int size;

    private Node head;

    public Stack() {
        head = new Node(null,null);
        size = 0;
    }

    public void push(T item){
        if(isEmpty()){
            Node node = new Node(null,item);
            head.next = node;

        }else {
            Node oldFirst = head.next;
            Node node = new Node(oldFirst,item);
            head.next = node;
        }
        size++;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        Node node = head.next;
        head.next = node.next;
        size--;
        return node.item;

    }

    public boolean isEmpty(){
        return size == 0;
    }

    private class Node{
        private Node next;

        private T item;

        public Node(Node next, T item) {
            this.next = next;
            this.item = item;
        }
    }


}
