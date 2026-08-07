package week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

    @Test
    public void test(){
        int[] nums1={4,1,2}, nums2={1,3,4,2};
        Assertions.assertArrayEquals(new int[]{-1, 3, -1}, nextGreaterElement(nums1, nums2));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        int[] ans=new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        ans[ans.length-1]=-1;
        map.put(nums2[nums2.length-1],-1);
        for (int i=nums2.length-1;i>=0;i--){
            while (!stack.isEmpty() && nums2[i]>stack.peek()){
                stack.pop();
                if(stack.isEmpty()){
                    ans[i]=-1;
                    map.put(nums2[i], -1);
                }

            }
            if(!stack.isEmpty() && nums2[i]<stack.peek()){
                ans[i]=stack.peek();
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        int[] output= new int[nums1.length];
        int index=0;
        for (int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                output[index++]=map.get(nums1[i]);
            }
        }
        return output;
    }
}
