package week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindKthBit {

    @Test
    public void test(){
        int n=5;
        Assertions.assertTrue(findBitSetRightShift(n,0));
    }

    @Test
    public void test1(){
        int n=5;
        Assertions.assertFalse(findBitSet(n,1));
    }
    @Test
    public void test2(){
        int n=5;
        Assertions.assertTrue(findBitSet(n,2));
    }


    public boolean findBitSet(int n, int k){
        int mask = 1 << k;
        int bitSet =  (n & mask);
        if(bitSet !=0) return true;
        else return false;
    }

    public boolean findBitSetRightShift(int n, int k){
        int modifiedVal = n >> k;
        int bitSet =  (modifiedVal & 1);
        if(bitSet !=0) return true;
        else return false;
    }
}
