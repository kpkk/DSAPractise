package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class RomanToInteger {

    @Test
    public void test() {
        String s = "III";
        Assertions.assertEquals(3, romanToInt(s));
    }

    @Test
    public void test1() {
        String s = "LVIII";
        Assertions.assertEquals(58, romanToInt(s));
    }

    @Test
    public void test2() {
        String s = "MCMXCIV";
        Assertions.assertEquals(1994, romanToInt(s));
    }














    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int sum = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(i!=0 && map.get(charArray[i-1]) < map.get(charArray[i])){
                sum-=map.get(charArray[i-1]);
                sum+=map.get(charArray[i])-map.get(charArray[i-1]);
            }else {
                sum+=map.get(charArray[i]);
            }
        }
        return sum;
    }
}
