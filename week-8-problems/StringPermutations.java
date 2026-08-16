package week8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class StringPermutations {

    @Test
    public void test() {
        String s = "ABC";
        Assertions.assertEquals(Arrays.asList("ABC", "ACB", "BAC", "BCA", "CBA", "CAB"), strPermutations(s));
    }

    public List<String> strPermutations(String s) {
        ArrayList<String> ans = new ArrayList<>();
        permutationsHelper(s, 0, s.length() - 1, ans);
        return ans;
    }

    public void permutationsHelper(String s, int l, int r, List<String> list) {
        // base case
        if (l == r) {
            list.add(s);
            return;
        }
        for (int i = l; i <= r; i++) {
            s = swap(l, i, s); // ABC -> ACB
            permutationsHelper(s, l + 1, r, list);
            // this below swap is done as part of back tracking
            s = swap(l, i, s); // ACB-> ABC
        }
    }

    public String swap(int l, int r, String s) {
        char[] charArray = s.toCharArray();
        char temp = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = temp;
        return String.valueOf(charArray);
    }
}
