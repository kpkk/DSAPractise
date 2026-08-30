package week10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LeastCommonSubSequence {

    @Test
    public void test(){
        String s1="abcde";
        String s2="ace";
        Assertions.assertEquals(3, longestCommonSubSequence(s1, s2));
    }

    public int longestCommonSubSequence(String s1, String s2){
        int[][]dp= new int[s1.length()][s2.length()];
        for (int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(s1, s2, s1.length()-1, s2.length()-1, dp);
    }

    public int helper(String s1, String s2, int p1, int p2, int[][] dp){
        if(p1<0 || p2<0) return 0;
        // match
        if(dp[p1][p2]!=-1) return dp[p1][p2];
        if(s1.charAt(p1)==s2.charAt(p2))
            return dp[p1][p2]=1 + helper(s1, s2, p1 - 1, p2 - 1, dp);
        // not match
        return dp[p1][p2]=Math.max(helper(s1, s2, p1 - 1, p2, dp), helper(s1, s2, p1, p2 - 1, dp));
    }
}
