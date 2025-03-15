import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        int result = 0;
        for (int i : L) result += i;
        return result;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer> evens_L = new ArrayList<>();
        for (int i : L) {
            if (i % 2 == 0) evens_L.add(i);
        }
        return evens_L;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        List<Integer> L = new ArrayList<>();
        for (int i : L1)
            for (int j : L2)
                if (i == j) L.add(i);
        return L;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int count = 0;
        for (String s : words)
            for (int i = 0; i < s.length(); i++)
                if (c == s.charAt(i))
                    count++;
        return count;
    }
}
