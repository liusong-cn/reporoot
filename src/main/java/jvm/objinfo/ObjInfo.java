package jvm.objinfo;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author: Administrator
 * @date: 2021/2/24 23:50
 * 查看对象字节信息
 */
public class ObjInfo {

    static class Demo{
        String name;
        int size;
    }

    public static void main(String[] args) {
        //jol java object layout,openjdk推出的对象检测工具
        System.out.println(ClassLayout.parseInstance(new Demo()).toPrintable());
    }
}
