import com.google.common.truth.Truth;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArrayDeque61B<T> implements Deque61B<T> {

    private static final int MINCAP = 8;
    private static final double SCALE = 2.;
    private static final double USAGE = 0.25;

    protected T[] items;
    protected int cap;
    protected int size;
    protected int head;

    public ArrayDeque61B() {
        cap = 8;
        size = 0;
        items = (T[]) new Object[MINCAP];
        head = 0;
    }

    protected int getIndex(int i) {
        return Math.floorMod(i, cap);
    }

    protected void resize(int newCap) {
        T[] newItems = (T[]) new Object[newCap];
        for (int i = 0; i < size; i++) {
            newItems[i] = get(i);
        }
        head = 0;
        cap = newCap;
        items = newItems;
    }

    protected void resizeUp() {
        // resize up when size is equal to cap;
        if (size >= cap) {
            resize((int) Math.round(cap * SCALE));
        }
    }

    protected void resizeDown() {
        // resize down when usage factor is less than USAGE and cap is bigger than MINCAP
        if (cap > MINCAP && size < cap * USAGE) {
            resize((int) Math.round(cap / SCALE));
        }
    }

    @Override
    public void addLast(T x) {
        resizeUp();
        items[getIndex(head + size)] = x;
        size++;
    }

    @Override
    public void addFirst(T x) {
        resizeUp();
        head--;
        items[getIndex(head)] = x;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        return items[getIndex(head + index)];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    // cap method is only for test.
    public int cap() {
        return cap;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            returnList.add(get(i));
        }
        return returnList;
    }

    @Override
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        T e = get(0);
        head++;
        size--;
        resizeDown();
        return e;
    }

    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        T e = get(size - 1);
        size--;
        resizeDown();
        return e;
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListDeque61BIterator();
    }

    private class ArrayListDeque61BIterator implements Iterator<T> {

        private int index;

        public ArrayListDeque61BIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T returnItem = get(index);
            index++;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        if (other instanceof ArrayDeque61B otherDeque) {
            if (size != otherDeque.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!get(i).equals(otherDeque.get(i))) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        List<String> listOfItems = new ArrayList<>();
        for (T x : this) {
            listOfItems.add(x.toString());
        }
        return "[" + String.join(", ", listOfItems) + "]";
    }
}
