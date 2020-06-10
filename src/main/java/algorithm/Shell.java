package algorithm;

import java.util.Arrays;

/**
 * @author: ls
 * @date: 2020/6/10 0010 09:07
 */
public class Shell {
    
    public static void sort(Comparable[] c){
        //确定初始步长
        int h = 1;
        while(h<c.length/2){
            h = 2*h +1;
        }
        //步长每次减小到h/2
        while(h>=1){
            //待插入元素索引为i,从索引h处开始，分组进行排序
            //把c[i]依次与c[i-h]、c[i-2h]、c[i-3h]...比较
            for (int i = h; i < c.length; i++) {
                //c[j]与c[j-h],c[j-2h]...  比较
                for (int j = i; j >=h; j-=h) {
                    //如果前面的大于后面的，则交换
                    if(greater(c[j-h],c[j])){
                        exchange(c,j-h,j);
                    }else {
                        break;
                    }
                }
            }
            h/=2;
        }
    }
    
    public static boolean greater(Comparable c1, Comparable c2){
        return c1.compareTo(c2) > 0;
    }
    
    public static void exchange(Comparable[] c,int i , int j){
        Comparable temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {5,2,6,9,1,3,10};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
