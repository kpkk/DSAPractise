package week9;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    @Test
    public void test(){
        int n=4;
        System.out.println(solveNQueens(n));
    }

    public List<List<String>> solveNQueens(int n){
        List<List<String >> ans= new ArrayList<>();
        char[][] board= new char[n][n];
        for (int i=0;i<board.length;i++){
            Arrays.fill(board[i], '.');
        }
        helper(0, board, ans);
        return ans;
    }

    public void helper(int col, char[][] board, List<List<String>> ans){
        if(col==board[0].length){
            ans.add(new ArrayList<>(convertToList(board)));
            return;
        }
        for (int row=0;row<board.length;row++){
            if(canQueenBePlaced(row, col, board)){
                board[row][col]='Q';
                helper(col+1, board, ans);
                board[row][col]='.';  // back tracking
            }
        }
    }

    public boolean canQueenBePlaced(int row, int col, char[][] board){
        int tempRow=row;
        int tempCol= col;

        // left side check
        while (col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        col=tempCol;

        // lower diagnol
        while (row<board.length && col>=0){
            if(board[row][col]=='Q') return false;
            row++;
            col--;
        }
        row=tempRow;
        col=tempCol;

        // upper diagnol
        while (row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        return true;
    }

    public List<String> convertToList(char[][] board){
        ArrayList<String> strings = new ArrayList<>();
        for (int i=0;i<board.length;i++){
            String s = new String(board[i]);
            strings.add(s);
        }
        return strings;
    }
}
