package week10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonSubString {

    @Test
    public void test(){
        String s1="ABCDGH";
        String s2="ACDGHR";
        Assertions.assertEquals(4, longestCommonSubString(s1, s2));
    }

    public int longestCommonSubString(String s1, String s2){
        int[][] dp= new int[s1.length()+1][s2.length()+1];
        int ans=0;
        for(int i=1;i<=s1.length();i++){
            for (int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans= Math.max(ans, dp[i][j]);
                }
                else dp[i][j]=0;
            }
        }
        return ans;
    }
}
