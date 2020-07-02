package algorithm.symbol;

/**
 * @author: ls
 * @date: 2020/6/28 0028 11:50
 * 符号表
 */
public class SymbolTable<Key,Value> {

    private int N;

    private Node head;

    public SymbolTable(){
        head = new Node(null,null,null);
        N = 0;
    }

    public int size(){
        return N;
    }

    public void put(Key key, Value value){
        Node n = head;
        while (n.next != null){
            n = n.next;
            if(n.key.equals(key)){
                n.value = value;
                break;
            }
        }
        //符号表插入时向第一个节点插入
        Node oldFisrt = head.next;
        Node newNode = new Node(key,value,oldFisrt);
        head.next = newNode;
        N++;
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
        Node n = head;
        while (n.next != null){
            n = n.next;
            if(n.key.equals(key)){
                return (Value) n.value;
            }
        }
        return null;
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

    public static void main(String[] args) {
        SymbolTable<Integer,String> s = new SymbolTable<>();
        s.put(3,"c");
        s.put(6,"f");
        s.put(1,"a");
        s.put(2,"b");
        System.out.println(s.getValue(3));
        s.delete(6);
        System.out.println(s.size() + "---" + s.getValue(6));
    }
}
