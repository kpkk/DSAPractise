package week8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindFactorial {

    @Test
    public void test() {
        int n = 5;
        Assertions.assertEquals(120, factorial(n));
    }

    public int factorial(int n) {
        if (n == 0) return 1;
        return factorial(n - 1) * n;
    }
}
