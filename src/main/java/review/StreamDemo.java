package review;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: ls
 * @date: 2021/2/18 14:15
 **/
public class StreamDemo {

    public static void main(String[] args) {
        streamUse1();
    }

    public static void streamUse1(){
        //构建stream后利用串行化和并行快速对集合元素进行处理
        Stream.of("one","two", "three", "four")
                .filter(s -> s.length() > 3)
                .peek(s -> System.out.println("string:" + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("uppercase:" + s))
                .collect(Collectors.toList());
    }
}
