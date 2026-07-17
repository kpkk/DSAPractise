package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

public class HappyNumber {

    @Test
    public void test(){
        int n=19;
        Assertions.assertTrue(isHappyNumber(n));
    }
    @Test
    public void test1(){
        int n=2;
        Assertions.assertFalse(isHappyNumber(n));
    }

    /**
     * Intialise a hashset of integers to store the sum of squares, for future look ups
     * initialise a temp variable temp and assign the value n
     * while temp !=0
     *  - get the sum of squares of each digit and get the resulting number
     *  - if the resulting sum is 1 then return true
     *  - if the sum is already stored in set then return false
     *  - store the resulting sum into hashset
     *  - assign the new resulting sum to temp;
     * return false in the end
     *
     * TC: O(n)
     * SC: O(n)
     * @param n
     * @return
     */

    public boolean isHappyNumber(int n){
        int temp=n;
        HashSet<Integer> set = new HashSet<>();
        while (temp!=0){
            int sumOfSquares = getSumOfSquares(temp);
            if(sumOfSquares==1) return true;
            if(set.contains(sumOfSquares)) return false;
            set.add(sumOfSquares);
            temp=sumOfSquares;
        }
        return false;
    }

    public int getSumOfSquares(int n){
        int sum=0;
        while (n!=0){
            int last=n%10;
            sum+=last*last;
            n/=10;
        }
        return sum;
    }
}
