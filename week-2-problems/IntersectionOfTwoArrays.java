package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

    @Test
    public void test() {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        Assertions.assertArrayEquals(new int[]{2}, findIntersection(nums1, nums2));
    }

    @Test
    public void test1() {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        Assertions.assertArrayEquals(new int[]{4, 9}, findIntersection(nums1, nums2));
    }

    @Test
    public void test2() {
        int[] nums1 = {4, 7, 9, 7, 6, 7}, nums2 = {5, 0, 0, 6, 1, 6, 2, 2, 4};
        Assertions.assertArrayEquals(new int[]{4,6}, findIntersection(nums1, nums2));
    }

//    public int[] findIntersection(int[] nums1, int[] nums2) {
//
//        HashSet<Integer> set = new HashSet<>();
//        HashSet<Integer> dupSet = new HashSet<>();
//        for (int i = 0; i < nums1.length; i++) {
//            set.add(nums1[i]);
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            if (set.contains(nums2[i]))
//                dupSet.add(nums2[i]);
//        }
//        ArrayList<Integer> integers = new ArrayList<>(dupSet);
//        int[] output = new int[dupSet.size()];
//        for (int i = 0; i < integers.size(); i++) {
//            output[i] = integers.get(i);
//        }
//        return output;
//    }

    public int[] findIntersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1]==nums2[p2]) {
                if(! list.contains(nums1[p1]))
                    list.add(nums1[p1]);
                p1++;p2++;
            }else if(nums1[p1]<nums2[p2]) p1++;
            else p2++;
        }
        int[] output= new int[list.size()];
        for (int i=0;i<list.size();i++){
            output[i]=list.get(i);
        }
        return output;
    }
}