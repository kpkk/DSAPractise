package week7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargestElement {

    @Test
    public void test() {
        int[] nums = {2, 1, 7, 8, 5, 4};
        int k = 3;
        Assertions.assertEquals(5, findKethlargestnaive(nums, k));
    }

    // space- O(k)
    // Time - O(klogk) +O(klogk)
    public int findKethlargest(int[] nums, int k) {
        // min
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        //PriorityQueue<Integer> maxPq = new PriorityQueue<>((n1, n2)->Integer.compare(n1,n2));
        // max
        //PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b)->b-a);
        //PriorityQueue<Integer> maxPq = new PriorityQueue<>((n1, n2)->Integer.compare(n2,n1));

        for (int i = 0; i < k; i++) { // O(k)
            pq.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) { // Ok(logn)
            if (nums[i] > pq.peek()) {
                Integer poll = pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }

    public int findKethlargestnaive(int[] nums, int k) {
        // min
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        //PriorityQueue<Integer> maxPq = new PriorityQueue<>((n1, n2)->Integer.compare(n1,n2));
        // max
        //PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b)->b-a);
        //PriorityQueue<Integer> maxPq = new PriorityQueue<>((n1, n2)->Integer.compare(n2,n1));

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        for (int i = 0; i < k-1; i++) {
            Integer poll = pq.poll();
        }
        return pq.peek();
    }
}
