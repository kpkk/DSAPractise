package week8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsStringPalindrome {

    @Test
    public void test(){
        String s="madam";
        Assertions.assertTrue(isStrPalindrome(s));
    }

    @Test
    public void test1(){
        String s="ate";
        Assertions.assertFalse(isStrPalindrome(s));
    }

    public boolean isStrPalindrome(String s){
        if(s.length()==1) return true;
        return palindromeHelper(s,0,s.length()-1);
    }

    public boolean palindromeHelper(String s, int left, int right){
        // base case
        if(left>=right){
            return true;
        }
        // logic
        if(s.charAt(left)!=s.charAt(right)) return false;
        return palindromeHelper(s, left+1, right-1);
    }
}
