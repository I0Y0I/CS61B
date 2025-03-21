package exercises.lists1;

public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        if (L == null)
            return null;
        return new IntList(L.first, Lists1Exercises.incrList(L.rest, x));
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        L.first -= x;
        if (L.rest != null)
            dincrList(L.rest, x);
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

//         Test your answers by uncommenting. Or copy and paste the
//         code for incrList and dincrList into IntList.java and
//         run it in the visualizer.
         System.out.println(L.get(1));
         System.out.println(incrList(L, 3));
         System.out.println(dincrList(L, 3));
    }
}
