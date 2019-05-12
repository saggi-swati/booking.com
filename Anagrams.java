import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Represent a group by a list of integers representing the index in the original list.
 * <p>
 * Anagrams : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
 * Note: All inputs will be in lower-case.
 * Input :
 * <p>
 * cat, god, atc, dog
 * <p>
 * Output :
 * [cat atc ]
 * [dog god ]
 */
public class Anagrams {

    private static ArrayList<ArrayList<String>> anagrams(final List<String> a) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            char[] c = a.get(i).toCharArray();
            Arrays.sort(c);
            String t = String.valueOf(c);
            if (map.get(t) == null) {
                ArrayList<String> l = new ArrayList<>();
                l.add(a.get(i));
                map.put(t, l);
            } else
                map.get(t).add(a.get(i));
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("cat");
        a.add("dog");
        a.add("god");
        a.add("odg");
        a.add("atc");
        ArrayList<ArrayList<String>> result = anagrams(a);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(
                    Arrays.toString(result.get(i).toArray()));
        }
    }
}
