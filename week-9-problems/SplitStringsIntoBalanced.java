package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SplitStringsIntoBalanced {

    @Test
    public void test(){
        String s="RLRRLLRLRL";
        Assertions.assertEquals(4, splitStrings(s));
    }

    public int splitStrings(String s){
        int lCount=0;
        int rCount=0;
        int count=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='L')
                lCount++;
            else
                rCount++;
            if(lCount==rCount){
                count++;
                lCount=0;
                rCount=0;
            }
        }
        return count;
    }
}
