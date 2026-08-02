package week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class DecodeString {

    @Test
    public void test(){
        String s="3[a]2[bc]";
        Assertions.assertEquals("aaabcbc", decodeString(s));
    }

    @Test
    public void test1(){
        String s="3[a2[c]]";
        Assertions.assertEquals("accaccacc", decodeString(s));
    }

    public String decodeString(String s){
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int index=0;
        String result="";
        while (index<s.length()){
            if(Character.isDigit(s.charAt(index))){ //3, 323, 3456 k[]
                int count=0;
                while (Character.isDigit(s.charAt(index))){ //'3'
                    // int i = s.charAt(index) - '0';
                    int numericValue = Character.getNumericValue(s.charAt(index)); //3
                    count=count*10+ numericValue;
                    index++;
                }
                countStack.push(count); //5

            }
            else if(s.charAt(index)=='['){
                stringStack.push(result);
                result="";
                index++;
            }
            else if(s.charAt(index)==']'){
                StringBuilder builder = new StringBuilder(stringStack.pop());
                Integer pop = countStack.pop(); //3
                for (int i=0;i<pop;i++){
                    builder.append(result);
                }
                result=builder.toString();
                index++;
            }
            else
                result+=s.charAt(index++);
        }

        return result;
    }
}
