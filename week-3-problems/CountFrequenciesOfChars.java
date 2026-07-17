package week3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CountFrequenciesOfChars {

    @Test
    public void test(){
        String s="hscdtftedjvadcccdhdbdiuu";
        countFrequencies(s);
    }

    @Test
    public void test1(){
        int[] nums={1,2,3,4,9,2,4};
        countFrequenciesInts(nums);
    }

    public void countFrequencies(String s){
        int[] ascii= new int[26];
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            ascii[ch-'0']++;
        }
        System.out.println(Arrays.toString(ascii));
    }

    public void countFrequenciesInts(int[] nums){
        int[] ascii= new int[10];
        for (int i=0;i<nums.length;i++){
            ascii[nums[i]-0]++;
        }
        System.out.println(Arrays.toString(ascii));
    }
}
