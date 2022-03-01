package algorithm.linear;


import java.util.Iterator;

/**
 * @author: ls
 * @date: 2022/3/1
 * @description:
 */
public class SequenceList2<T> implements Iterable<T> {


    private int N;

    private T[] eles;

    public SequenceList2(int cap) {
        if (cap <= 0)
            throw new IllegalArgumentException("容量不能为负数");
        this.eles = (T[]) new Object[cap];
    }

    public void insert(T t) {
        if (N >= eles.length) {
            resize();
        }
        eles[N++] = t;
    }

    public void insert(T t, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("插入位置不正确");
        }
        if (N >= eles.length) {
            resize();
        }
        for (int i = N; i > index; i--) {
            eles[i] = eles[i - 1];
        }
        eles[index] = t;
        N++;

    }

    public T remove(int index) {
        if (index < 0 || index > N) {
            throw new IllegalArgumentException("索引位置越界");
        }
        T re = eles[index];
        for (int i = index + 1; i < N; i++) {
            eles[i - 1] = eles[i];
        }
        N--;
        return re;
    }

    public T get(int index) {
        if (index < 0 || index > N) {
            throw new IllegalArgumentException("索引位置越界");
        }
        return eles[index];
    }

    public void clear() {
        N = 0;
    }

    public void resize() {
        T[] temp = eles;
        eles = (T[]) new Object[N * 2];
        for (int i = 0; i < temp.length; i++) {
            eles[i] = temp[i];
        }
    }

    public boolean isEmpty() {
        return N <= 0;
    }

    public int indexOf(T t) {
        for (int i = 0; i < eles.length; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public int getLength() {
        return N;
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
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
        SequenceList2<Integer> s = new SequenceList2<>(2);
        s.insert(1);
        s.insert(2);
        s.insert(3);
        // s.remove(0);
        // s.insert(4);
        // Iterator<Integer> i = s.iterator();
        // while (i.hasNext()){
        //     System.out.println(i.next());
        // }
        // System.out.println(s.getLength());
        s.insert(5, 2);
        s.forEach(t -> {
            System.out.println(t);
        });
    }
}
