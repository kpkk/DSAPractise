package week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddBinary {

    @Test
    public void test() {
        String a = "11", b = "1";
        Assertions.assertEquals("100", addBinary(a, b));
    }

    @Test
    public void test1() {
        String a = "1010", b = "1011";
        Assertions.assertEquals("10101", addBinary(a, b));
    }

    @Test
    public void test2() {
        String a = "0", b = "0";
        Assertions.assertEquals("0", addBinary(a, b));
    }

    @Test
    public void test3() {
        String a = "1", b = "1";
        Assertions.assertEquals("10", addBinary(a, b));
    }

    @Test
    public void test4() {
        String a = "0", b = "1";
        Assertions.assertEquals("1", addBinary(a, b));
    }

    /**
     * Initialise a string builder to accumulate the running sum of two binary digits
     * initialise two pointers i, j to keep track of the bits from the two digits and a carry to track of resulted carry after the sum
     * iterate both the strings from right, while either of the strings still have chars or carry is 1
     *  - initialise a local variable called sum, to have the updated carry value
     *  - if i>=0 get the int value of char at i from string a and accumulate that to sum
     *  - if j>=0 get the value of char at j from string b and accumulate that to sum
     *  - append sum%2 to the string builder, as it will 0 or 1 based on the sum being even or odd
     *  - assign the value sum/2 to carry to have the actual carry after summing the digits
     *
     * return the reversed version of sb and a string value
     *
     * @param a
     * @param b
     * @return
     */

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }

    public String addBinaryBruteForce(String a, String b) {
        if (a.equals("0") && b.equals("0")) return "0";
        int len = Math.max(a.length(), b.length());
        int aSum = getIntegerSum(a);
        int bSum = getIntegerSum(b);
        int cSum = aSum + bSum;
        String s = constructBinary(cSum);
        return s.substring(s.length() - (len + 1));
    }

    public int getIntegerSum(String s) {
        int sum = 0;
        int power = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1')
                sum += Math.pow(2, power);
            power++;
        }
        return sum;
    }

    public String constructBinary(int n) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < 32; i++) {
            boolean bit = (n & (1 << i)) > 0;
            if (bit) s.insert(0, "1");
            else s.insert(0, "0");
        }
        return String.valueOf(s);
    }
}