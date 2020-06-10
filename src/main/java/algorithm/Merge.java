package algorithm;

import java.util.Arrays;

/**
 * @author: ls
 * @date: 2020/6/10 0010 19:40
 * 归并排序
 * 1.将所有元素分组直到每组只有一个元素
 * 2.合并相邻两组并排序直到合并最后两个大组
 */
public class Merge {

    private static Comparable[] assist;

    public static void sort(Comparable[] v){
        //注意需要将辅助数组初始化，否则为null
        assist = new Comparable[v.length];
        int low = 0;
        int high = v.length -1;
        sort(v,low,high);
    }

    public static void sort(Comparable[] v,int low, int high){
        //安全性校验
        if(low >= high){
            return;
        }
        int mid = (low +high)/2;
        sort(v,low,mid);
        sort(v,mid+1,high);
        merge(v,low,mid,high);

    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exchange(Comparable[] v,int i, int j){
        Comparable temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    public static void merge(Comparable[] v, int low, int mid, int high){
        //定义三个指针 p1, p2,p
        int p1 = low;
        int p2 = mid + 1;
        int p = low;

        //从v[p1]和v[p2]开始比较,将较小的数存在辅助数据中靠左的位置，左右两个子组中只要某个数付给了辅助数组，那么
        //移动指针，p也移动
        while (p1 <= mid && p2 <= high){
            if(less(v[p1],v[p2])){
                //注意p++的用法，p自增是下一次循环
                assist[p++] = v[p1++];
            }else {
                assist[p++] = v[p2++];
            }
        }


        //当p1移动到最右端，那么将另外一个子组中未填充的添加到assit中，不用排序了，因为已经是排序状态
//        if(p1 == mid){
//            for (int i = p2; i <=high; i++) {
//                assist[i] = v[i];
//            }
//        }
        while (p1 <= mid){
            assist[p++] = v[p1++];
        }

        //当p2移动到最右端，那么将另外一个子组中未填充的添加到assit中，不用排序了，因为已经是排序状态
//        if(p2 == high){
//            for (int i = p1; i <= mid ; i++) {
//                assist[i] = v[i];
//            }
//        }
        while (p2<= high){
            assist[p++] = v[p2++];
        }

        //将assist中的元素对应放回v中
        for (int i = low; i <= high ; i++) {
            v[i] = assist[i];
        }

    }

    public static void main(String[] args) {
        Integer[] integers = {3,5,6,1,2,9,8};
        sort(integers);
        System.out.println(Arrays.asList(integers));
    }
}
