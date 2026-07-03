import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {


    @Test
    public void test(){
        int n=3;
        Assertions.assertEquals(List.of("1","2","Fizz"), fizzBuzz(n));
    }

    /***
     *
     * Initialise an arraylist of string type
     * iterate from 1 till n
     * check if i is divisible by
     *  - 3 & 5 if yes add "FizzBuzz" to the list
     *  - if its only divisble by 3 then add Fizz
     *  - if its only divisble by 5 then add Buzz
     *  - if its not divisible by any then i as string
     *  TC: O(n) SC: O(n)
     *
     *
     */

    public List<String> fizzBuzz(int n){
        ArrayList<String> list = new ArrayList<>();
        for (int i=1;i<=n;i++){
            if(i%5==0 && i%3==0) list.add("FizzBuzz");
            else if (i%3==0) list.add("Fizz");
            else if (i%5==0) list.add("Buzz");
            else list.add(i+"");
        }
        return list;
    }
}
