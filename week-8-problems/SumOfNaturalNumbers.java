package week8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumOfNaturalNumbers {

    @Test
    public void test(){
        int n=5;
        Assertions.assertEquals(15, sum(n));
        Assertions.assertEquals(15, sumOpp(0,n));
    }

    public int sum(int n){
        // base case
        if(n==0)
            return 0;
        // recurrence relation
        return sum(n-1)+n;
    }

    public int sumOpp(int index, int n){
        // base case
        if(index==n)
            return n;
        // recurrence relation
        return sumOpp(index+1, n)+index;
    }
}
