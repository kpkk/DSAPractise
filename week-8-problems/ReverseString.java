package week8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseString {

    @Test
    public void test(){
        String str="abc";
        Assertions.assertEquals("cba", reverse(str));
    }

    public String reverse(String str){
        if(str.length()==1)
            return str;
        return reverse(str.substring(1))+str.charAt(0);
    }
}
