public class UnionFind {
    int[] tree;
    int size;

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        size = N;
        tree = new int[size];
        for (int i = 0; i < size; i++) {
            tree[i] = -1;
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        return -tree[parent(v)];
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        return tree[v];
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        if (v1 < 0 || v1 >= size || v2 < 0 || v2 >= size) {
            throw new IllegalArgumentException();
        }
        return find(v1) == find(v2);
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        if (v < 0 || v >= size) {
            throw new IllegalArgumentException();
        }

        if (tree[v] < 0) {
            return v;

        }
        // not root? find root recursively
        tree[v] = find(tree[v]);
        return tree[v];
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        if (v1 < 0 || v1 >= size || v2 < 0 || v2 >= size) {
            throw new IllegalArgumentException();
        }

        // Find root of two item.
        int r1 = find(v1);
        int r2 = find(v2);
        // If same root, skip
        if (r1 == r2) {
            return;
        }
        // Select r1 as the smaller tree
        if (tree[r1] < tree[r2]) {
            r1 = r1 ^ r2;
            r2 = r1 ^ r2;
            r1 = r1 ^ r2;
        }
        // Connect r1 to r2
        tree[r2] += tree[r1];
        tree[r1] = r2;
    }

}
