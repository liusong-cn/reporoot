package review.map2dto;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ls
 * @date: 2020/6/9 0009 22:10
 */
public class Map2Dto {

    public  void change(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","zhang");
        map.put("age",3);
        UseCase u = JSON.parseObject(JSON.toJSONString(map),UseCase.class);
        System.out.println(u);
    }

    public static void main(String[] args) {
        Map2Dto m = new Map2Dto();
//        m.change();
        UseCase u = new UseCase();
        u =  m.change(u);
        System.out.println(u);
    }

    public <T> T change(T t){
        Map<String,Object> map = new HashMap<>();
        map.put("name","zhang");
        map.put("age",3);
        T t1 = JSON.parseObject(JSON.toJSONString(map), (Type) t.getClass());
        return t1;
    }


}
