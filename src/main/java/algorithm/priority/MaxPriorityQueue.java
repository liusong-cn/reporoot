package algorithm.priority;

/**
 * @author: ls
 * @date: 2020/6/28 0028 15:02
 * 最大优先队列，保证队列中最大的元素先出，利用堆这种数据结构实现
 *  最小优先队列和最大优先队列相反，因此在设计insert和delMin时判断大小采用相反的策略即可
 */
public class MaxPriorityQueue<T extends Comparable<T>> {

    private T[] items;

    private int N;

    public MaxPriorityQueue(int capacity){
        items = (T[]) new Comparable[capacity +1];
        N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(T t){
        items[++N] = t;
        raise(N);
    }

    public void sink(int i){
        //下沉到没有子节点为止
        while (2*i <= N){
            int max;
            if(2*i + 1 <= N){
                if(less(2*i+1,2*i)){
                    max = 2*i;
                }else {
                    max = 2*i +1;
                }
            }else {
                max = 2*i;
            }
            if(less(i,max)){
                exchange(i,max);
            }else {
                break;
            }
            i = max;
        }
    }

    public T delMax(){
        T max = items[1];
        exchange(1,N);
        items[N] = null;
        N--;
        sink(1);
        return max;
    }

    public void raise(int i){
        //直到上浮到根节点为止
        while (i > 1){
            if(less(i/2,i)){
                exchange(i/2,i);
            }
            i = i/2;
        }
    }

    public boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }

    public void exchange(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

}
