package week7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class FindKPossibleNumbersFromArr {

    @Test
    public void test(){
        int[] nums={2,5,6}; int k=10;
        Assertions.assertArrayEquals(new int[]{2,5,6,22,25,26,52,55,56,62}, findNumbers(nums, k));
    }

    public int[] findNumbers(int[] nums, int k){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        int count=0;
        int[] ans= new int[k];
        while (count<k){
            Integer root = deque.poll();
            for (int i=0;i<nums.length;i++){
                if(count==k) break;
                int number= root*10+nums[i];
                deque.add(number);
                ans[count++]=number;
            }
        }
        return ans;
    }
}
