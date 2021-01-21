package strategies;

/**
 * @author: ls
 * @date: 2021/1/13 13:41
 **/
public class Client {

    public void use(Operation operation){
        System.out.println(operation.tryHandle(new AHandler()));
    }
}
