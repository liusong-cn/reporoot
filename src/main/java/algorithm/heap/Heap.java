package algorithm.heap;

/**
 * @author: ls
 * @date: 2020/6/28 0028 09:24
 * 堆可以看做完全二叉树，其底层是数组
 * 堆要求父节点大于子节点，但是并没有要求两个子节点的顺序
 * 某节点为a[k],则父节点为a[k/2],两个子节点为a[2k]、a[2k+1]
 */
public class Heap<T extends Comparable<T>> {

    //存储元素
    private T[] items;

    //堆的大小
    private int N = 0;

    public Heap(int capacity){
        this.items = (T[]) new Comparable[capacity +1];
    }

    public boolean less(int i , int j){
        return items[i].compareTo(items[j])<0;
    }

    public void exchange(int i , int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //插入算法，需要先插入，上浮元素
    public void insert(T item){
        //由于堆中的元素需要从1开始，这样方便后续的操作，因此第一个元素位于索引1处
        items[++N] = item;
        raise(N);
    }
    //根节点元素最大，删除后需要保持heap有序
    public T delMax(){
        T max = items[1];
        //交换末尾元素和根节点元素
        exchange(1,N);
        N--;
        //交换后的根节点需要下沉找到合适的位置
        sink(1);
        //删除交换后的末尾元素，即交换前的根节点
        items[N] = null;
        return max;
    }

    //上浮算法，用于比较元素和父元素的大小，保证父元素比子元素大
    public void raise(int i){
        //最多上浮到根节点就可以，根节点索引为1
        while (i >1){
            //当前节点比父节点大则交换顺序
            if(less(i/2,i)){
                exchange(i,i/2);
            }
            //交换之后上浮层级，每次减小i/2
            i = i/2;
        }
    }

    //元素下沉到合适位置，比较当前元素和子元素的较大值，如果当前大于则不用交换，否则交换
    public void sink(int i){
        while (2*i <= N){
            int max;
            //当前节点有右子节点
            if(2*i+1 <= N){
                if(less(2*i,2*i +1)){
                    max = 2*i+1;
                }else {
                    max = 2*i;
                }
            }else {
                //当前节点没有右子节点
                max = 2*i;
            }
            //当前节点小于子节点的最大值
            if(less(i,max)){
                exchange(i,max);
            }else {
                break;
            }
            //交换后继续比较
            i = max;
        }
    }

    public T get(int i){
        return items[i];
    }

    public static void main(String[] args) {
        Heap<String> heap  = new Heap<>(5);
        heap.insert("a");
        heap.insert("b");
        heap.insert("c");
        heap.insert("d");
        heap.insert("e");
        System.out.println(heap.get(1));
        heap.delMax();
        System.out.println(heap.get(1));

    }



}
