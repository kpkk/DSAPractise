package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class PermutationInString {

    @Test
    public void test() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Assertions.assertTrue(checkInclusion(s1, s2));
    }

    @Test
    public void test1() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        Assertions.assertFalse(checkInclusion(s1, s2));
    }

    @Test
    public void test2() {
        String s1 = "adc";
        String s2 = "dcda";
        Assertions.assertTrue(checkInclusion(s1, s2));
    }

    /**
     *
     * initialise integer variables left, right as pointers and formed to know if all the characters in permutation string ot accumulated
     * Initialise two hashmaps, to store character and its frequency
     * iterate till the length of s1 and add all the characters into the hashmap s1Map
     * iterate the s1 string using the right pointer and push each char into s2map
     * if the char at right is present in s1Map and its frequencies are same then increment formed
     *  Check if both the maps are equal, if yes return true
     *  once we accumulated all the chars (formed== s1Map.size()) then remove . deduce the character frequency using left pointer
     *  continuously check if both maps are same, if yes return true
     *  if the char at left index is present in s1Map and the frequency of it in s2Map is less than s1Map, then formed--
     *  increment left and right
     *  return false if nothing matches
     * @param s1
     * @param s2
     * @return
     *
     * TC: O(n)
     * SC: O(n)
     */

    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0, formed = 0;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        while (right < s2.length()) {
            char ch = s2.charAt(right);
            s2Map.put(ch, s2Map.getOrDefault(ch, 0) + 1);
            if (s1Map.containsKey(ch) && s1Map.get(ch).intValue() == s2Map.get(ch))
                formed++;
            while (formed == s1Map.size()) {
                if (s1Map.equals(s2Map)) return true;
                char leftChar = s2.charAt(left);
                s2Map.put(leftChar, s2Map.getOrDefault(leftChar, 0) - 1);
                if (s2Map.get(leftChar) == 0) s2Map.remove(leftChar);

                if(s1Map.containsKey(leftChar) && s2Map.getOrDefault(leftChar,0)< s1Map.get(leftChar))
                    formed--;
                left++;
            }
            right++;
        }
        return false;
    }
}
