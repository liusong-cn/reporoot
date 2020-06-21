package algorithm.linked;

/**
 * @author: ls
 * @date: 2020/6/17 0017 15:38
 * 单向链表是否有环，以及环的入口
 */
public class FastSlowCircle<T> {

    //节点类，存储元素
    private static class Node<T>{
        T item;
        Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    //判断是否有环
    public boolean isCircle(Node<T> first){
        Node fast = first;
        Node slow = first;
        while (fast != null && fast.next != null){
            //快指针每次移动两步
            fast = fast.next.next;
            slow = slow.next;
            //有相等则证明有环，因为速度差的存在终会相遇
            if(fast.item.equals(slow.item)){
                return true;
            }
        }
        return false;
    }

    //查找环的入口，证明涉及到复杂数学知识，结论是：当快慢指针相遇，再定义一个指针从头开始，其移速和慢指针一致，那么这两个
    //慢指针相遇是的节点即为入口
    public Node getEntrance(Node<T> first){
        Node fast = first;
        Node slow = first;
        Node temp = null;
        while (fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)){
                temp = first;
                continue;
            }
            if(temp!=null){
                temp = temp.next;
                if(temp.equals(slow)){
                    return temp;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FastSlowCircle<String> c = new FastSlowCircle<>();
        Node<String> fifth = new Node<>("e",null);
        Node<String> fourth = new Node<>("d",fifth);
        Node<String> third = new Node<>("c",fourth);
        Node<String> second = new Node<>("b",third);
        Node<String> first = new Node<>("a",second);
        Node<String> sixth = new Node<>("f",second);
        fifth.next = sixth;
        System.out.println(c.getEntrance(first).item);
        System.out.println(c.isCircle(first));

    }

}
