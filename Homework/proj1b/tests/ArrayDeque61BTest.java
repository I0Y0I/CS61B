import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

     @Test
     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
     void noNonTrivialFields() {
         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                 .toList();

         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
     }

    @Test
    /** In this test, we have three different assert statements that verify that addFirst works correctly. */
    public void addFirstTestBasic() {
        Deque61B<String> lld1 = new ArrayDeque61B<>();

        lld1.addFirst("back"); // after this call we expect: ["back"]
        assertThat(lld1.toList()).containsExactly("back").inOrder();

        lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
        assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

        lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
          */
    }

    @Test
    /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
     *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
    public void addLastTestBasic() {
        Deque61B<String> lld1 = new ArrayDeque61B<>();

        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    /** This test performs interspersed addFirst and addLast calls. */
    public void addFirstAndAddLastTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
    }

    // Below, you'll write your own tests for ArrayDeque61B.
    @Test
    public void constructorTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        assertThat(lld1.size()).isEqualTo(0);

    }

    @Test
    public void sizeTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        // New LinkedList should be empty;
        assertThat(lld1.isEmpty()).isTrue();
        // Insert 2 item;
        lld1.addLast(0);   // [0]
        assertThat(lld1.size()).isEqualTo(1);
        lld1.addLast(1);   // [0, 1]
        assertThat(lld1.size()).isEqualTo(2);
        // lld1 should not be empty now;
        assertThat(lld1.isEmpty()).isFalse();
    }

    @Test
    public void getTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lld1.get(0)).isEqualTo(-2);
        assertThat(lld1.get(3)).isEqualTo(1);
        assertThat(lld1.get(6)).isNull();
    }

//    @Test
//    public void getRecursiveTest() {
//        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
//        lld1.addLast(0);   // [0]
//        lld1.addLast(1);   // [0, 1]
//        lld1.addFirst(-1); // [-1, 0, 1]
//        lld1.addLast(2);   // [-1, 0, 1, 2]
//        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]
//
//        assertThat(lld1.getRecursive(0)).isEqualTo(-2);
//        assertThat(lld1.getRecursive(3)).isEqualTo(1);
//        assertThat(lld1.getRecursive(6)).isNull();
//    }

    @Test
    public void removeFirstAddRemoveLastTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]

        assertThat(lld1.removeFirst()).isEqualTo(0);
        assertThat(lld1.removeLast()).isEqualTo(1);
        assertThat(lld1.removeFirst()).isNull();
        assertThat(lld1.removeLast()).isNull();
    }

    @Test
    public void resizeUpTest() {
        ArrayDeque61B<Integer> lld1 = new ArrayDeque61B<>();
        // After add 10000 items
        for (int i = 0; i < 5000; i++) {
            lld1.addFirst(i);
            lld1.addLast(i);
        }

        assertThat(lld1.cap()).isGreaterThan(10000);
        assertThat(lld1.size()).isEqualTo(10000);
        assertThat(lld1.get(0)).isEqualTo(4999);
        assertThat(lld1.get(4999)).isEqualTo(0);
        assertThat(lld1.get(5000)).isEqualTo(0);
        assertThat(lld1.get(9999)).isEqualTo(4999);

        for (int i = 0; i < 9000; i++) {
            lld1.removeLast();
        }
        assertThat(lld1.cap()).isLessThan(4000);
        assertThat(lld1.size()).isEqualTo(1000);
        assertThat(lld1.get(0)).isEqualTo(4999);
        assertThat(lld1.get(999)).isEqualTo(4000);

        for (int i = 0; i < 1000; i++) {
            lld1.removeFirst();
        }
        assertThat(lld1.cap()).isEqualTo(8);
        assertThat(lld1.size()).isEqualTo(0);
    }

    @Test
    public void iteratorTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();

        lld1.addLast(1); // after this call we expect: ["front"]
        lld1.addLast(2); // after this call we expect: ["front", "middle"]
        lld1.addLast(3); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1).containsExactly(1, 2, 3);
    }

    @Test
    public void equalsTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        Deque61B<Integer> lld2 = new ArrayDeque61B<>();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld2.addFirst(3);
        lld2.addFirst(2);

        // size not equal
        assertThat(lld1.equals(lld2)).isFalse();
        assertThat(lld2.equals(lld1)).isFalse();

        lld2.addFirst(2);

        // size equal but item not equal
        assertThat(lld1.equals(lld2)).isFalse();
        assertThat(lld2.equals(lld1)).isFalse();

        lld2.removeFirst();
        lld2.addFirst(1);

        // equal
        assertThat(lld1.equals(lld2)).isTrue();
        assertThat(lld2.equals(lld1)).isTrue();
    }

    @Test
    public void toStringTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();

        lld1.addLast(1); // after this call we expect: ["front"]
        lld1.addLast(2); // after this call we expect: ["front", "middle"]
        lld1.addLast(3); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toString()).isEqualTo("[1, 2, 3]");
    }
}
