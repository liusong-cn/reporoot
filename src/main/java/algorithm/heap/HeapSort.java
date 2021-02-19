package algorithm.heap;

import java.util.Arrays;

/**
 * @author: ls
 * @date: 2020/6/28 0028 10:30
 * 堆排序可以分成两步：堆构造，堆排序
 * 堆构造：创建一个新数组，把原数组
 * 0~length-1的数据拷贝到新数组的1~length处，再从新数组长度的一半处开始往1索引处扫描（从右往左），然后
 * 对扫描到的每一个元素做下沉调整即可
 *
 * 堆排序：对构造好的堆，我们只需要做类似于堆的删除操作，就可以完成排序。
 * 1.将堆顶元素和堆中最后一个元素交换位置；
 * 2.通过对堆顶元素下沉调整堆，把最大的元素放到堆顶(此时最后一个元素不参与堆的调整，因为最大的数据已经到
 * 了数组的最右边)
 * 3.重复1~2步骤，直到堆中剩最后一个元素
 */
public class HeapSort {

    //对数组中元素按从小到大顺序排序
    public static void sort(Comparable[] source){
        Comparable[] heap = new Comparable[source.length +1];
        creatHeap(source,heap);
        //定义最大的索引
        int N = heap.length -1;
        while (N != 1){
            //交换堆顶元素和堆底元素
            exchange(heap,1,N);
            //交换后堆底元素已经最大，减小N使得堆底元素不参与下沉
            N--;
            //对堆顶元素下沉使得堆有序
            sink(heap,1,N);
        }
        System.arraycopy(heap,1,source,0,source.length);
    }

    public static void creatHeap(Comparable[] source, Comparable[] des){
        //copy一个长度为source.length +1 的数组，从一开始存储元素，可以理解为一个无序的堆
        System.arraycopy(source,0,des,1,source.length);
        //从堆中二分之一索引处倒序遍历节点，对每个节点做下沉操作,因最下层节点占所有节点的一半，因此除2就是从倒数第二层开始遍历
        for (int i = des.length/2; i > 0 ; i--) {
            sink(des,i,des.length -1);
        }
    }

    public static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j]) < 0;
    }

    public static void exchange(Comparable[] heap,int i, int j){
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    //在heap中，对i处元素下沉，范围是0-range
    public static void sink(Comparable[] heap,int i,int range){
        while (2*i<=range){
            int max;
            //有右子节点
            if(2*i+1<= range){
                if(less(heap,2*i,2*i+1)){
                    max = 2*i +1;
                }else {
                    max = 2*i;
                }
            }else {
                //没有右子节点
                max = 2*i;
            }
            //当前节点比子节点大则不交换
            if(!less(heap,i,max)){
                break;
            }
            exchange(heap,i,max);
            i = max;

        }
    }

    public static void main(String[] args) {
        Comparable[] source = {1,2,6,8,3,9,18,12};
        HeapSort.sort(source);
        System.out.println(Arrays.asList(source).toString());
    }

}
