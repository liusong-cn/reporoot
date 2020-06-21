package algorithm.linked;

/**
 * @author: ls
 * @date: 2020/6/17 0017 14:42
 * 测试快慢指针问题
 */
public class FastSlowIndex<T> {

    public static void main(String[] args) {
        Node<String> first = new Node<>("a",null);
        Node<String> second = new Node<>("b",null);
        Node<String> third = new Node<>("c",null);
        Node<String> fourth = new Node<>("d",null);
        first.next = second;
        second.next = third;
        third.next = fourth;
        System.out.println(getMid(first));
    }

    //节点类，存储元素
    private static class Node<T>{
        T item;
        Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    //T参数用于需要在实例化时传入真实参数，而静态方法没有办法实例化，因此不能使用泛型T
    public static String getMid(Node<String> first){
        Node<String> fast = first;
        Node<String> slow = first;
        //此处不是使用的短路与，因此需要注意顺序
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }
}
