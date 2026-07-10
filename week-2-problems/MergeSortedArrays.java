package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSortedArrays {

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, merge(nums1, m, nums2, n));
    }

    @Test
    public void test1() {
        int[] nums1 = {0}, nums2 = {1};
        int m = 0, n = 1;
        Assertions.assertArrayEquals(new int[]{1}, merge(nums1, m, nums2, n));
    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int index = nums1.length - 1;
        int p1 = m, p2 = n;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[index--] = nums2[p2];
                p2--;
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[index--] = nums1[p1];
                p1--;
            }
        }
        while (p1>=0){
            nums1[index--]=nums1[p1--];
        }
        while (p2>=0){
            nums1[index--]=nums2[p2--];
        }
        return nums1;
    }
}
