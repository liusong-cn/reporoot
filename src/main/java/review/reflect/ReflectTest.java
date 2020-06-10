package review.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ls
 * @date: 2020/6/9 0009 21:38
 */
public class ReflectTest {

    public static void main(String[] args) {
        Class<?> clazz = UseCase.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getType());
            System.out.println("------");
            Type t = f.getGenericType();
            if(t instanceof ParameterizedType){
                ParameterizedType p = (ParameterizedType) t;
                Type[] tt = p.getActualTypeArguments();
                for (Type type : tt) {
                    System.out.println("参数化类型：" + type);
                }
            }
        }
//        Map<String,Object> map = new HashMap<>();
//        Class<?> c = map.getClass();
//        Type[] ts = c.getGenericInterfaces();
//        Arrays.asList(ts).forEach(t -> System.out.println(t));
//        System.out.println("泛型父类：" +c.getGenericSuperclass());
    }

    protected class UseCase{

        private String name;

        private List<Integer> integerList;
    }
}
