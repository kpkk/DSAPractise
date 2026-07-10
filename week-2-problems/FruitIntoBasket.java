package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class FruitIntoBasket {

    @Test
    public void test() {
        int[] nums = {1, 2, 1};
        Assertions.assertEquals(3, totalFruit(nums));
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 2, 2};
        Assertions.assertEquals(4, totalFruit(nums));
    }

    @Test
    public void test2() {
        int[] nums = {3,3,3,1,2,1,1,2,3,3,4};
        Assertions.assertEquals(5, totalFruit(nums));
    }

    /***
     * Initialise two pointers left, right with 0, also currFruits and maxFruits to keep track max current fruits collected and current fruits count
     * Initialise a hashmap to keep track of the basket size to be 2 as per problem statement
     * till the fast pointer, right reaches end, add the current fruit type into map with 1 as its occurrence so far
     * if the size goes beyond 2, since we have only two baskets
     *  - till the time the size comesback to 2, reduce or remove chars from left and increment
     * keep computing the math max of the maxFruits
     * increment right to repeat the process
     * return maxFruits
     * TC: O(n+k)-> O(n)
     * SC: O(1)
     */

    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, maxFruits = 0, currFruits = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right],0)+1);
            currFruits++;
            while (map.size()>2){
                if(map.get(fruits[left])==1) map.remove(fruits[left]);
                else map.put(fruits[left], map.getOrDefault(fruits[left],0)-1);
                currFruits--;
                left++;
            }
            maxFruits=Math.max(maxFruits, currFruits);
            right++;
        }
        return maxFruits;
    }
}
