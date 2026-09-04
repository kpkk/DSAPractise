package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSumAfterKrotations {

    @Test
    public void test(){
        int[] nums={4,2,3};
        int k=1;
        Assertions.assertEquals(5, largestSumAfterKnegotiations(nums, k));
    }

    @Test
    public void test1(){
        int[] nums={2,-3,-1,5,-4};
        int k=2;
        Assertions.assertEquals(13, largestSumAfterKnegotiations(nums, k));
    }

    @Test
    public void test2(){
        int[] nums={5,6,9,-3,3};
        int k=2;
        Assertions.assertEquals(20, largestSumAfterKnegotiations(nums, k));
    }

    @Test
    public void test3(){
        int[] nums={3,-1,0,2};
        int k=3;
        Assertions.assertEquals(6, largestSumAfterKnegotiations(nums, k));
    }

    public int largestSumAfterKnegotiations(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        while (k>0){
            Integer poll = pq.poll();
            poll= poll*-1;
            pq.offer(poll);
            k--;
        }
        int sum=0;
        while (!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }

}
