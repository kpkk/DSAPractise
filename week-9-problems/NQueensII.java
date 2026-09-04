package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NQueensII {

    @Test
    public void test() {
        int n = 4;
        Assertions.assertEquals(2, totalNQueens(n));
    }

    public int totalNQueens(int n) {
        char[][] grid = new char[n][n];
        for (int i=0;i<grid.length;i++){
            Arrays.fill(grid[i], '.');
        }
       // int count=0;
        return helper(grid, 0);
    }

    public int helper(char[][] grid, int col) {
        if (col==grid[0].length){
            return 1;
        }
        int count=0;
        for (int i=0;i<grid.length;i++){
            if(canPlaceQueen(grid, i, col)){
                grid[i][col]='Q';
                count+=helper(grid, col+1);
                grid[i][col]='.';
            }
        }
        return count;
    }

    public boolean canPlaceQueen(char[][] grid, int row, int col){
        int tempRow=row;
        int tempCol=col;
        while (row>=0 && col>=0){
            if(grid[row][col]=='Q'){
                return false;
            }
            row--;
            col--;
        }
        row=tempRow;
        col=tempCol;
        while (col>=0){
            if(grid[row][col]=='Q'){
                return false;
            }
            col--;
        }
        col=tempCol;
        while (row<grid.length && col>=0){
            if(grid[row][col]=='Q'){
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
}
