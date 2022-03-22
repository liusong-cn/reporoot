package VO;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ls
 * @date: 2022/3/22
 * @description: 验证范型参数的获取
 */
public class Son extends Parent<String,Integer> {

    public static void main(String[] args) throws ClassNotFoundException {
        // ParameterizedType type = (ParameterizedType) Son.class.getGenericSuperclass();
        // for (Type actualTypeArgument : type.getActualTypeArguments()) {
        //     System.out.println(actualTypeArgument.getTypeName());
        // }

        Map<String, Son> map = new HashMap<>();
        map.put("son", new Son());
        ParameterizedType son = (ParameterizedType) map.get("son").getClass().getGenericSuperclass();
        for (Type type : son.getActualTypeArguments()) {

            System.out.println(type.getTypeName());
            Class<?> aClass = Class.forName(type.getTypeName());
            System.out.println(aClass.getTypeName());

        }
    }
}
