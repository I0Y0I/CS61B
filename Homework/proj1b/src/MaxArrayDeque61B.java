import java.util.Comparator;

public class MaxArrayDeque61B<T> extends ArrayDeque61B<T> {

    Comparator<T> c;

    public MaxArrayDeque61B(Comparator<T> c) {
        this.c = c;
    }

    public T max() {
        return max(c);
    }

    public T max(Comparator<T> cmp) {
        if (isEmpty()) {
            return null;
        }

        T maxItem = get(0);
        for (T t : this) {
            if (cmp.compare(maxItem, t) < 0) {
                maxItem = t;
            }
        }
        return maxItem;
    }
}
