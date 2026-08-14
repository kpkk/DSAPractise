package week7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum {

    @Test
    public void test() {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        Assertions.assertEquals(List.of(List.of(1, 2), List.of(1, 4), List.of(1, 6)), kSmallestPairs(nums1, nums2, 3));
    }

    public List<List<Integer>> kSmallestPair(int[] nums1, int[] nums2, int k) {
        ArrayList<List<Integer>> output = new ArrayList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int p1 = 0;
        while (p1 < nums1.length) {
            int p2 = 0;
            int i = nums1[p1];
            while (p2 < nums2.length) {
                int j = nums2[p2];
                output.add(List.of(i, j));
                p2++;
            }
            p1++;
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.get(0) + a.get(1), b.get(0) + b.get(1)));
        for (int i = 0; i < output.size(); i++) {
            pq.offer(output.get(i));
        }
        for (int i = 0; i < k; i++) {
            ans.add(pq.poll());
        }
        return ans;
    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result= new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int num: nums1){
            pq.offer(new int[]{num+nums2[0], 0});
        }

        while (k>0 && ! pq.isEmpty()){
            int[] poll = pq.poll();
            int sum = poll[0];
            int pos = poll[1];
            ArrayList<Integer> currPair = new ArrayList<>();
            currPair.add(sum-nums2[pos]);
            currPair.add(nums2[pos]);
            result.add(currPair);
            if(pos+1<nums2.length){
                pq.offer(new int[]{sum-nums2[pos]+nums2[pos+1], pos+1});
            }
            k--;
        }
        return result;
    }
}
