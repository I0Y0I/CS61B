package deque;

import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    public LinkedListDeque61B() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    private class Node {
        T    item;
        Node prev;
        Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public Node addNext(T x) {
            Node n = new Node(x, this, next);
            next.prev = n;
            next = n;
            return n;
        }

        public Node addPrev(T x) {
            Node n = new Node(x, prev, this);
            prev.next = n;
            prev = n;
            return n;
        }

        public T remove() {
            prev.next = next;
            next.prev = prev;
            return item;
        }
    }

    int size;
    Node sentinel;

    @Override
    public void addFirst(T x) {
        sentinel.addNext(x);
        size++;
    }

    @Override
    public void addLast(T x) {
        sentinel.addPrev(x);
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for (Node n = sentinel.next; n != sentinel; n = n.next) {
            returnList.add(n.item);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        return sentinel.next.remove();
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        return sentinel.prev.remove();
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node n = sentinel.next;
        for (; index > 0; index--) {
            n = n.next;
        }
        return n.item;
    }

    private Node getRecursiveHelper(Node n, int index) {
        if (n == sentinel || index == 0) {
            return n;
        }
        return getRecursiveHelper(n.next, index - 1);
    }

    @Override
    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index).item;
    }
}
