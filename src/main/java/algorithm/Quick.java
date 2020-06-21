package algorithm;

import java.util.Arrays;

/**
 * @author: ls
 * @date: 2020/6/12 0012 16:42
 * 1.快速排序，通过以首元素为界，分为大于此和小于此的两组，依据此规则分解至最小的组
 * 2.相邻两个组进行排序，由于每个组已有序，且左下右大，因此整体有序
 */
public class Quick {

    //整体数组排序
    public static void sort(Comparable[] v){
        int low = 0;
        int high = v.length -1;
        sort(v,low,high);
    }

    //对其中一部分排序
    public static void sort(Comparable[] v,int low, int high){
        if(low >= high)
            return;
        int partition = partition(v,low,high);
        sort(v,low,partition-1);
        sort(v,partition +1, high);
    }

    //分组，将low到high之间的分为左右两组,返回中间元素的索引
    public static int partition(Comparable[] t,int low ,int high){
        //定义key元素，左右两个索引
        Comparable key = t[low];
        int left = low;
        int right = high +1;
        while (true){
            //右索引向左移动，找到一个比key小的元素
            while (less(key,t[--right])){
                if(right == low)
                    break;
            }

            //左索引向右移动，找到一个比key大的元素
            while(less(t[++left],key)){
                if(left == high){
                    break;
                }
            }
            //直到左右索引相等
            if(left >= right) {
                break;
            }else {
                //交换两索引处元素
                exchange(t,left,right);

            }

        }
        //交换起始索引和最后的最右索引的值
        exchange(t,low,right);
        return right;
    }

    //比较大小
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    public static void exchange(Comparable[] t, int i, int j){
        Comparable temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {1,6,2,4,9,7,8,3};
        sort(a);
        System.out.println(Arrays.asList(a));
    }
}
