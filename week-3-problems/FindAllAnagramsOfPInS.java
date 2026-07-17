package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsOfPInS {

    @Test
    public void test() {
        String s = "cbaebabacd", p = "abc";
        Assertions.assertEquals(Arrays.asList(0, 6), findAllAnagrams(s, p));
    }

    public List<Integer> findAllAnagrams(String s, String p) {
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (sMap.equals(pMap)) list.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            if (sMap.get(s.charAt(i - pMap.size())) > 1)
                sMap.put(s.charAt(i - pMap.size()), sMap.getOrDefault(s.charAt(i - pMap.size()), 0) - 1);
            else
                sMap.remove(s.charAt(i - pMap.size()));
            if (sMap.equals(pMap)) list.add(i-p.length()+1);
        }
        return list;
    }
}
