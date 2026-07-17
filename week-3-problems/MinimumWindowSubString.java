package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubString {


    @Test
    public void test() {
        String s = "ADOBECODEBANC", t = "ABC";
        Assertions.assertEquals("BANC", minWindowSubString(s, t));
    }

    @Test
    public void test1() {
        String s = "aa", t = "aa";
        Assertions.assertEquals("aa", minWindowSubString(s, t));
    }

    /**
     *
     * Initialise two HashMaps to store the characters from both the strings
     * initialise pointers left, right and minLen to store the len of the window, startIndex to capture the start index of window
     * Initialise a int variable called, that determines whether all the chars in t string present in current window of chars
     * iterate the t string and store the chars and their frequencies in tMap
     * using the right pointer iterate the array till the end
     * push the character into the sMap and its frequency
     * if the char is present in tMap and the frequencies in both the maps are same then increment formed
     * as long as the formed is same as the length of tmap, (to reduce window len, while having all t chars in the window)
     *  - get the window length, and assign it to minLen if its smaller
     *  - store the current left in startIndex as that's going to define the start of the window, to take the substring later
     *  - try to decrement the window, by removing the char at left index from sMap and move pointer
     *  - if the char present in tMap and the frequency of that char in sMap is less than tMap, then decrement formed
     *  - increment left
     * increment right
     * after the loop exit, if minLen is still with the assigned value then return ""
     * return the substring between startIndex and minLen
     *
     * TC: O(n)
     * SC: O(n)
     * @param s
     * @param t
     * @return
     */

    public String minWindowSubString(String s, String t) {

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, startIndex = -1, formed = 0;
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (right < s.length()) {
            char ch = s.charAt(right);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            if (tMap.containsKey(ch) && tMap.get(ch).intValue() == sMap.get(ch).intValue()) {
                formed++;
            }
            while (formed == tMap.size()) {
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                sMap.put(leftChar, sMap.getOrDefault(leftChar, 0) - 1);
                if (sMap.get(leftChar) == 0) sMap.remove(leftChar);
                if (tMap.containsKey(leftChar) && sMap.getOrDefault(leftChar, 0) < tMap.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(startIndex, startIndex + minLen);
    }


}
