package algorithm.linear;


import java.util.Iterator;

/**
 * @author: ls
 * @date: 2020/6/15 0015 15:18
 * 顺序表
 * 顺序表实现iterable接口，内部通过一个内部类，该内部类重写hashnext、next方法即可实现让顺序表通过foreach遍历
 */
public class SequenceList<T> implements Iterable<T>{

    //顺序表当前长度
    private int N;

    //存贮元素的数组
    private T[] eles;

    //清空表
    public void clear(){
        N = 0;
    }

    //获取线性表长度
    public int length(){
        return N;
    }

    public SequenceList(int capacity){
        //编写时由于没有注意引用的Object非java.lang.Object,导致arraystoreexception
        this.eles = (T[]) new Object[capacity];
        this.N = 0;
    }

    //向表中追加元素
    public void insert(T t){
        //此种方式容器容量固定
//        if(N == eles.length)
//            throw new RuntimeException("当前线性表已满");
        //支持容量扩展
        if(N == eles.length)
            resize(2*N);
        eles[N++] = t;
    }

    //向表中指定位置插入元素
    public void insert(int i, T t){
        if(i < 0 || i > N -1)
            throw  new  RuntimeException("当前插入位置不合法");
//        if(N == eles.length)
//            throw new RuntimeException("当前线性表已满");
        //改为支持动态扩容的
        if(N == eles.length) {
            resize(2*N);
        }

        //将i位置后的元素向后挪一位
        for (int j = N -1 ; j > i; j--) {
            eles[j] = eles[j -1];
        }
        eles[i] = t;
        //当前容量加1
        N++;

    }

    //移除指定位置元素且返回该元素
    public T remove(int i){
        if( i > N -1 || i < 0)
            throw  new RuntimeException("索引位置不合法");
        T result = get(i);
        for (int j = i+1; j <= eles.length -1 ; j++) {
            eles[j-1] = eles[j];
        }
        //当前容量减一
        N--;
        //适当减容
        if(N >0 && N < eles.length/4)
            //减容到一半
            resize(eles.length/2);
        return result;
    }

    //返回指定元素第一次出现的索引，若不存在则返回-1
    public int indexOf(T t){
        if(t == null)
            throw new RuntimeException("查找的元素不合理");
        for (int i = 0; i < N; i++) {
            if(eles[i].equals(t))
                return i;
        }
        return -1;
    }

    //返回指定索引处的元素
    public T get(int i){
        if(i > N -1 || i < 0)
            throw  new RuntimeException("索引位置不合法");
        return eles[i];
    }

    //判断线性表是否为空
    public boolean isEmpty(){
        return N == 0;
    }




    //给容器扩容
    public void resize(int length){
        T[] temp = eles;
        eles = (T[]) new Object[length];
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }

    @Override
    public Iterator iterator(){
        return new SIterator();
    }


    private class SIterator implements Iterator{

        private int cur;

        @Override
        public boolean hasNext() {
            return cur < N;
        }

        @Override
        public T next() {
            return eles[cur++];
        }
    }

    public static void main(String[] args) {
        SequenceList<String> s = new SequenceList<>(4);
        s.insert("a");
        s.insert("b");
        s.insert("c");
        s.insert("d");
        s.insert("e");


    }



}
