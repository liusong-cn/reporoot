package jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Administrator
 * @date: 2021/2/23 23:43
 * 用于验证堆oom
 * VM Args: -xms20m -xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> oomObjectList = new ArrayList<>();
        while (true){
            oomObjectList.add(new OOMObject());
        }
    }
}
