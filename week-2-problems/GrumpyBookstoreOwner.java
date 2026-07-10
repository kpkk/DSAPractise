package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrumpyBookstoreOwner {

    @Test
    public void test() {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy =    {0, 1, 0, 1, 0, 1, 0, 1};
        int x = 3;
        Assertions.assertEquals(16, maxSatisfied(customers, grumpy, x));
    }

    /**
     * Initialise variables called maxCustomers=0, cust=0 to track the satisfied customers so far and max satisfied customers
     * iterate the customers / grumpy array to compute the satisfied customers when the owner is not at all grumpy (grumpy[i]=0)
     * assign the cust to maxCustomers
     * Iterate the customers / grumpy array from 0 till the length and accumulate satisfied customers,when owner is grumpy (grumpy[i]=1)
     * Until i reaches the X, accumulate the customers[i] to to cust and compute the maxCustomers
     * once i reaches x
     *  - if the value at index i-x is 1 in grumpy array then deduce that from cust and
     *  - if the value at index i is 1 then add that to cust and take the maxCustomers
     * return the max customers
     * @param customers
     * @param grumpy
     * @param x
     * @return
     */

    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int maxCustomers=0, cust=0;
        for (int i=0;i<customers.length;i++){
            if(grumpy[i]==0)
                cust+=customers[i];
        }
        maxCustomers=Math.max(maxCustomers, cust);
        for (int i=0;i<customers.length;i++){
            if(grumpy[i]==1){
                cust+=customers[i];
            }
            if(i>=x){
                if(grumpy[i-x]==1) cust-=customers[i-x];
            }
            maxCustomers=Math.max(maxCustomers, cust);
        }
        return maxCustomers;
    }
}
