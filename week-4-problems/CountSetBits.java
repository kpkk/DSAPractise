package week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountSetBits {

    @Test
    public void test() {
        int n = 11;
        Assertions.assertEquals(3, countSetBits(n));
    }

    public int countSetBits(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) count++;
        }
        return count;
    }
}
