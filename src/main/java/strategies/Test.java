package strategies;

/**
 * @author: ls
 * @date: 2021/1/13 13:39
 **/
public class Test {

    public static void main(String[] args) {
        Client client = new Client();
        client.use(new Operation2());
    }
}
