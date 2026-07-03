import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseInteger {

    @Test
    public void test() {
        int n = 123;
        Assertions.assertEquals(321, reverse(n));
    }

    @Test
    public void test1() {
        int n = -123;
        Assertions.assertEquals(-321, reverse(n));
    }

    @Test
    public void test2() {
        int n = 3;
        Assertions.assertEquals(3, reverse(n));
    }

    public int reverse(int n) {
        if (n >= 0 && n < 10) return n;
        boolean isNegative = false;
        int rev = 0;
        if (n < 0) {
            isNegative = true;
            n = n * -1;
        }
        while (n > 0) {
            int last = n % 10;
            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && last > 7) return 0;
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && last < -8) return 0;
            rev = rev * 10 + last;
            n = n / 10;

        }
        return isNegative ? rev * -1 : rev;
    }
}
