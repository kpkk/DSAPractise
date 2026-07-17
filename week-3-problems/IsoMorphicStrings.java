package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphicStrings {

    @Test
    public void test() {
        String s = "egg", t = "add";
        Assertions.assertTrue(ismorphicStrings(s, t));
    }

    @Test
    public void test1() {
        String s = "paper", t = "title";
        Assertions.assertTrue(ismorphicStrings(s, t));
    }

    @Test
    public void test2() {
        String s = "foo", t = "bar";
        Assertions.assertFalse(ismorphicStrings(s, t));
    }

    @Test
    public void test3() {
        String s = "badc", t = "baba";
        Assertions.assertFalse(ismorphicStrings(s, t));
    }

    @Test
    public void test4() {
        String s = "bbbaaaba", t = "aaabbbba";
        Assertions.assertFalse(ismorphicStringsAsciiApproach(s, t));
    }

    @Test
    public void test5() {
        String s = "abba", t = "abab";
        Assertions.assertFalse(ismorphicStringsAsciiApproach(s, t));
    }

    @Test
    public void test6() {
        String s = "aab", t = "aba";
        Assertions.assertFalse(ismorphicStringsAsciiApproach(s, t));
    }

    public boolean ismorphicStrings(String s, String t) {

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (Integer i=0;i<s.length();i++){
            if(map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i)) return false;
        }
        return true;
    }

    /**
     * Intialise two ascii arrays of size 256 to be able to store anything in ascii range
     * iterate the s string and get the each char from both the strings (as lengths are equal)
     * if the value at the index in both the arrays is diff i.e tha pattern in the strings is not same return false
     * initialise index with i+1, to know where was the last index it occurred (we use i+1 instead of i because i starts at 0 in arrays, updating with 0 is as good as not seen)
     * @param s
     * @param t
     * @return
     */
    public boolean ismorphicStringsAsciiApproach(String s, String t) {
        int[] arrS=new int[256];
        int[] arrT=new int[256];
        for (int i=0;i<s.length();i++){
            char chs=s.charAt(i);
            char cht=t.charAt(i);
            if(arrS[chs] != arrT[cht]) return false;
            arrS[chs]= i+1;
            arrT[cht]= i+1;
        }
        return true;
    }
}
