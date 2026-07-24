package week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Search2DMatrix {

    @Test
    public void test() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        Assertions.assertTrue(searchMatrix(matrix, target));
    }

    @Test
    public void test1() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 13;
        Assertions.assertFalse(searchMatrix(matrix, target));
    }

    /**
     * initialise indices low=0, high=matrix.length*matrix.length[0]-1
     * while low and high are not meeting each other
     * compute mid point (cell number)
     * - we need to get the matrix cell value in terms of indices from the cell number
     * - row= mid/matrix[0].length
     * - col= mid% matrix[0].length
     * - if matrix[row][col]==target return true
     * - else if matrix[row][col]>target move high=mid-1;
     * - else low=mid+1;
     * return false
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = (matrix.length * matrix[0].length) - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
