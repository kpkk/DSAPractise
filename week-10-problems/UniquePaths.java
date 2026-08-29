package week10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class UniquePaths {

    @Test
    public void test(){
        int m=3, n=7;
        Assertions.assertEquals(28, uniquePathsTabulation(m, n));
    }

    public int uniquePaths(int m, int n){
        int[][]dp= new int[m+1][n+1];
        for (int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return grid(m-1,n-1, dp);
    }

    public int grid(int row, int col, int[][] dp){
        if(row==0 && col==0) return 1; // grid[0][0]
        if(row<0 || col<0) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        return dp[row][col]=grid(row-1, col, dp)+grid(row, col-1, dp);
    }

    public int uniquePathsTabulation(int m, int n){
        int[][] dp= new int[m][n];
        for (int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for (int i=0;i<n;i++){
            dp[0][i]=1;
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }











    public int uniquePathsii(int m, int n){
        return gridBottomUp(0,0, m, n);
    }

    public int gridBottomUp(int row, int col, int m, int n){
        if(row==m-1 && col==n-1) return 1; // grid[0][0]
        if(row>m-1 || col>n-1) return 0;
        return gridBottomUp(row+1, col, m, n)+gridBottomUp(row, col+1, m, n);
    }
}
