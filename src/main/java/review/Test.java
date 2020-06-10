package review;

/**
 * @author: ls
 * @date: 2020/6/9 0009 10:01
 */
public class Test {

    public static void main(String[] args) {
        String name = "main";
        pass(name);
        System.out.println(name);
    }

    static void pass(String name){
        name = "pass";
        System.out.println(name);
    }
}
