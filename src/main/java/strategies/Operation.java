package strategies;

/**
 * @author: ls
 * @date: 2021/1/13 13:35
 **/
public interface Operation {

    default String tryHandle(AHandler handler){
        handler.handle("c");
        String r = handle("a");
        return r;
    }

    String handle(String arg);
}
