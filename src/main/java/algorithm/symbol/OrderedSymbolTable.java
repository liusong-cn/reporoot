package algorithm.symbol;

/**
 * @author: ls
 * @date: 2020/6/28 0028 14:30
 * 有序符号表
 */
public class OrderedSymbolTable<Key extends Comparable<Key>,Value> {

    private int N;

    private Node head;

    public OrderedSymbolTable(){
        head = new Node(null,null,null);
        N = 0;
    }

    public int size(){
        return N;
    }

    public void delete(Key key){
        Node n = head;
        while (n.next != null){
            if(n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    public Value getValue(Key key){

        return null;
    }

    //按自然增长的顺序添加元素
    public void put(Key key, Value value){
        Node pre = head;
        Node cur = head.next;

        //找到比key大或等于key的节点
        while (cur != null && key.compareTo((Key) cur.key)>0){
            pre = cur;
            cur = cur.next;
        }
        if(cur != null && ((Key) cur.key).compareTo(key) == 0){
            cur.value = value;
            N++;
            return;
        }

        Node newNode = new Node(key,value,cur);
        pre.next = newNode;
        N++;
    }


    private class Node<Key,Value>{
        private Key key;

        private Value value;

        private Node next;

        public Node(Key key,Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
