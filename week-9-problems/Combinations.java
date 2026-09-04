package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    /**
     * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
     *
     * You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 4, k = 2
     * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
     * Explanation: There are 4 choose 2 = 6 total combinations.
     * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
     * Example 2:
     *
     * Input: n = 1, k = 1
     * Output: [[1]]
     * Explanation: There is 1 choose 1 = 1 total combination.
     */

    @Test
    public void test(){
        int n=4, k=2;
        System.out.println(combinations(n,k));
        Assertions.assertEquals(Arrays.asList(Arrays.asList(1,2),Arrays.asList(1,3),Arrays.asList(1,4),Arrays.asList(2,3),Arrays.asList(2,4),Arrays.asList(3,4)), combinations(n, k));
    }

    @Test
    public void test1(){
        int n=4, k=3;
        System.out.println(combinations(n,k));
       // Assertions.assertEquals(Arrays.asList(Arrays.asList(1,2),Arrays.asList(1,3),Arrays.asList(1,4),Arrays.asList(2,3),Arrays.asList(2,4),Arrays.asList(3,4)), combinations(n, k));
    }

    public List<List<Integer>> combinations(int n, int k){
        List<List<Integer>> ans= new ArrayList<>();
        helper(1, n, k, ans, new ArrayList<Integer>());
        return ans;
    }
    public void helper(int index, int n, int k, List<List<Integer>> ans, List<Integer> ds){
        if(ds.size()==k){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i=index;i<=n;i++){
            ds.add(i);
            helper(i+1,n,k,ans,ds);
            ds.removeLast();
        }
    }
}
