package week7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class FindKthLarestValueInArr {

    @Test
    void test2(){
        int[] nums={2,1,7,8,5,4};
        int k=3;
        Assertions.assertEquals(5, findKthLargestNumber(nums, k));
    }

    public int findKthLargestNumber(int[] nums, int k){
       // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num: nums){
            if(pq.size()<k){
                pq.offer(num);
            }
            else {
                if(num>pq.peek()){
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        return pq.peek();
    }
}
