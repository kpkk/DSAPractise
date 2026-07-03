import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixDiagnolSum {

    @Test
    public void test() {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        Assertions.assertEquals(25, diagnolSum(mat));
    }

    public int diagnolSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
        }
        int len = mat[0].length - 1;
        for (int i = 0; i < mat[0].length; i++) {
            if (!(i == len)) {
                sum += mat[i][len];
            }
            len--;
        }
        return sum;
    }
}
