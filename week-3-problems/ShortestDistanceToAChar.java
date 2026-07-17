package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShortestDistanceToAChar {

    @Test
    public void test() {
        String s = "loveleetcode"; char c = 'e';
        Assertions.assertArrayEquals(new int[]{3,2,1,0,1,0,0,1,2,2,1,0}, shortestDistanceToChar(s, c));
    }

    /**
     * intialise an integer array to store the distance of each char from the given char e
     * intualise an integer variable called index with s.length or some max value (a default value)
     * Iterate the array from left to right
     *  - if the char at the index is matcching with given char e then make index=0 and update in the output array nums[i]=0
     *  - else insert index default value at the index in output array
     *  - increment the index
     *  - do the above process from right to left as well, so that we can know the min distance
     *  - while updating in the array take the min of existing value in the array and current index, so that we have shortest distance between the char
     *
     *  Tc: O(n)
     *  SC: O(n)
     * @param s
     * @param c
     * @return
     */

    public int[] shortestDistanceToChar(String s, char c) {
        int[] nums = new int[s.length()];
        int index=s.length();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)==c) index=0;
            nums[i]=index++;
        }
        index=s.length();
        for (int i=s.length()-1;i>=0;i--){
            if (s.charAt(i)==c) index=0;
            nums[i]=Math.min(index++, nums[i]);
        }
        return nums;
    }
}
