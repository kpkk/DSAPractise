package week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

public class ArrangeCoins {

    @Test
    public void test() {
        int n = 3;
        Assertions.assertEquals(2, arrangeCoins(n));
    }

    /**
     * Intution:
     * Since to build stair case i we need i coins, this looks to be a pattern of sum of natural numbers
     * k*(k+1)/2=n => k^2+k=2n=> k=sqrt(2n) when removed k constant
     * so to for each stair case we need (mid*(mid+1)/2 coins
     * if thats less than n then set the answer and go right to see if we can build another stair
     * else bring high=mid-1 to reduce the stair case
     * return ans
     *
     * Note: we have used 65356 as high initial value because we sqrt(n), when n=2^31-1, the value doesn't go beyond 65536
     *         this will help solve overflow issues
     * @param n
     * @return
     */

    public int arrangeCoins(int n) {
        int low = 1, high = 65536, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * (mid + 1)/2 <= n) {
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }
}