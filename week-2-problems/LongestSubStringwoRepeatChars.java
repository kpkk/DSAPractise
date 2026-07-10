package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LongestSubStringwoRepeatChars {


    @Test
    public void test(){
        String s="abcabcbb";
        Assertions.assertEquals(3, lengthOfLongestSubStringHashMap(s));
    }

    /***
     * Initialise the pointers left=0, right=0, len=0
     * initialise an ascii array of length 128 because the problem said string contain alphabets, digits, other chars as well
     * iterate the string using the right pointer (fast pointer)
     * initialise the index in ascii array of the character, i.e. internally get the ascii number of the character and update the index
     * if the index of any character is greater than 1, try to deduct the characters from left, increment left since we should have unique chars
     * once the duplicate characters got deleted then take the length using the pointers (right-left+1)
     * compute the math.max of existing max len vs current len
     * increment the right pointer
     * return the length
     * TC: O(n)
     * SC: O(n)
     */

    public int lengthOfLongestSubstring(String s){
        int left=0, right=0, len=0;
        int[] ascii=new int[128];
        while(right<s.length()){
            ascii[s.charAt(right)]++;
            while(ascii[s.charAt(right)]>1){
                ascii[s.charAt(left++)]--;
            }
            len=Math.max(len, right-left+1);
            right++;
        }
        return len;
    }

    public int lengthOfLongestSubStringHashMap(String s){
        int left=0, right=0, maxLen=0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right<s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);

            while (map.get(s.charAt(right))>1){
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0)-1);
                left++;
            }
            maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
