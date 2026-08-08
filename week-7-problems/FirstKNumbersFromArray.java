package week7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class FirstKNumbersFromArray {

    @Test
    public void test(){
        int[] nums={2,5,6};
        int k=5;
        Assertions.assertArrayEquals(new int[]{2,5,6,22,25}, findNumbers(nums, k));
    }

    public int[] findNumbers(int[] nums, int k){
        //Queue<Integer> queue = new LinkedList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int count=0;
        queue.offer(0);
        int[] ans= new int[k];
        while (count<k){ //4<5
            int root= queue.poll();
            for (int i=0;i<nums.length;i++){ //5
                if(count>=k) break;
                int number = root * 10 + nums[i];
                ans[count++]=number;
                queue.offer(number);
            }
        }
        return ans;
    }
}
