package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatInAMaze {

    @Test
    public void test(){
        int[][] grid=  {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        Assertions.assertEquals(Arrays.asList("DDRDRR", "DRDDRR"), ratInMaze(grid));
    }

    public List<String> ratInMaze(int[][] grid){
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        helper(0, 0, grid, ans,"", visited);
        return ans;
    }

    public void helper(int row, int col, int[][] grid, List<String> ans, String moves, boolean[][] visited){
        if(row==grid.length-1 && col==grid[0].length-1){
            ans.add(moves);
            return;
        }
//        Has this cell been visited before?
//        is that move possible, which means cell value=1
//        are we going out of bounds or not
        // D
        if(row+1<grid.length && grid[row+1][col]!=0 && visited[row+1][col]==false){
            visited[row+1][col]=true; // mark the cell as visited
            helper(row+1, col, grid, ans, moves+"D",visited);
            visited[row+1][col]=false; // unmark the cell as further path is not possible
        }
        //L
        if(col-1>=0 && grid[row][col-1]!=0 && visited[row][col-1]==false){
            visited[row][col-1]=true; // mark the cell as visited
            helper(row, col-1, grid, ans, moves+"L",visited);
            visited[row][col-1]=false; // unmark the cell as further path is not possible
        }
        //R
        if(col+1<grid[0].length && grid[row][col+1]!=0 && visited[row][col+1]==false){
            visited[row][col+1]=true; // mark the cell as visited
            helper(row, col+1, grid, ans, moves+"R",visited);
            visited[row][col+1]=false; // unmark the cell as further path is not possible
        }
        //U
        if(row-1>=0 && grid[row-1][col]!=0 && visited[row-1][col]==false){
            visited[row-1][col]=true; // mark the cell as visited
            helper(row-1, col, grid, ans, moves+"U",visited);
            visited[row-1][col]=false; // unmark the cell as further path is not possible
        }
    }
}
