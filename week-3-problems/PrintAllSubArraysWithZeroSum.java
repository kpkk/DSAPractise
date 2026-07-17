package week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrintAllSubArraysWithZeroSum {

    @Test
    public void test() {
        int[] nums = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        printAllSubArrays(nums);
    }

    public void printAllSubArrays(int[] nums) {

        HashMap<Integer, List<Integer>> prefixMap = new HashMap<>();
        prefixMap.put(0, Arrays.asList(-1));
        int sum = 0;
        ArrayList<List<Integer>> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixMap.containsKey(sum)) {
                List<Integer> list = prefixMap.get(sum);
                for (int j = 0; j < list.size(); j++) {
                    // list.add(i);
                    integers.add(List.of(list.get(j) + 1, Integer.valueOf(i)));
                    //  System.out.println(Arrays.toString(Arrays.copyOfRange(nums, prefixMap.getOrDefault(sum, 0) + 1, i + 1)));
                }
            }

            prefixMap.put(sum, List.of(i));
        }
        System.out.println(integers);
    }
}
