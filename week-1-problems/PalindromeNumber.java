import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeNumber {

    @Test
    public void test() {
        int n = 121;
        Assertions.assertTrue(palindromeNumberOpt(n));
    }

    @Test
    public void test1() {
        int n = 1000021;
        Assertions.assertFalse(palindromeNumberOpt(n));
    }

    /***
     * Convert the given integer into string value
     * convert the string into a char array
     * initialise two pointers left=0, right=length-1 to traverse
     * iterate the array until left and right crosses
     * initialise an output string variable
     * iterate the reversed array and form a string version
     * compare if the reversed string is same as the input value in string format
     *  - if yes return true else false
     *  TC: O(n) SC:O(n)
     */

    public boolean palindromeNumber(int n) {
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left++] = charArray[right];
            charArray[right--] = temp;
        }
        String output = "";
        for (int i = 0; i < charArray.length; i++) {
            output += charArray[i];
        }
        return output.equals(s);
    }

    /***
     * if the input number is negative then return false
     * initialise a variable temp assign with input value to perform intermediate operations
     * initialise a variable called divisor to know the positions in the number and to reduce it incrementally
     * while the x >=10, multiply divisor by 10 to get the decimal places and reduce the number by 10
     * again set the temp with value x as the above iteration must have reduced the value to 0
     * while the number temp not equal to 0
     *  - get the right most bit by doing a mod with 10
     *  - get the left most bit by doing a division with divisor
     *  - if the first most and last most bits are not same, can return false
     *  - reduce the number in both the ends as well as the divisor, as it needs to be reduced according to the temp
     *  - temp % divisor - will eliminate the left most value Eg: 121%100 -> 21
     *  - temp / 10 -> will elimniate the left most bit Eg: 121/10 -> 12 .... 12/10 ->2
     *  - div/=100 -> since we are taking of two positions from temp at any given time, div should be cut by 100 as well
     * return true at the end
     * TC: O(n) SC: O(1)
     */

    public boolean palindromeNumberOpt(int x) {

        if (x < 0) return false;
        int temp = x;
        int divisor = 1;
        while (temp >= 10) {
            divisor *= 10;
            temp /= 10;
        }
        temp = x;
        while (temp != 0) {
            int last = temp % 10;
            int first = temp / divisor;
            if (last != first) return false;
            temp %= divisor;
            temp /= 10;
            divisor /= 100;
        }
        return true;
    }
}
