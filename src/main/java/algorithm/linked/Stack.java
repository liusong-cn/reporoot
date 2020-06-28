package algorithm.linked;

/**
 * @author: ls
 * @date: 2020/6/19 0019 09:14
 * FILO 先进后出
 */
public class Stack<T> {

    private Node head;

    private int N;

    public Stack(){
        head = new Node(null,null);
        N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    //为了先进后出，所以每次将新元素插入到head的下一个
    public void push(T item){
        if(isEmpty()) {
            Node node = new Node(null, item);
            head.next = node;
        }else {
            Node oldFirst = head.next;
            Node newNode = new Node(oldFirst,item);
            head.next = newNode;
        }
        N++;
    }

    //每次弹出栈顶元素
    public T pop(){
        if(isEmpty())
            return null;
        Node n = head.next;
        head.next = n.next;
        N--;
        return n.item;
    }


    private class Node{
        Node next;
        T item;

        public Node(Node next,T item) {
            this.next = next;
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.push("c");
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s.pop());
    }
}
