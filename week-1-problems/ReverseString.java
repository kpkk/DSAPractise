/***
 * Problem solving template
 *
 * 1. Did I understand the problem? yes or no -> yes
 *
 *         If no ask the person to provide with more details with examples
 *         If yes go to the next step
 *
 *         What is the input(s)? -> String
 *         What is the expected output? -> String
 *         Do I’ve constraints to solve the problem? no constraints
 *         Do Ive all the information to go to the next steps -> no questions
 *              some possible questions:
 *                  - should we reverse the entire statement
 *                  - should we reverse the alphabets in the words alone by keeping the order
 *                  - should we reverse words as well as the alphabets
 *         How big is your test data set will be?
 *
 * 2. Test data set
 *         Minimum  3 data set including positive, negative and edge
 *         Validate with the interviewer if the data set is fine by his/ her assumptions
 *
 *          Hi -> iH
 *              Build -> dliuB
 *          how are you -> uoy era woh
 *          "" -> throw exception
 *          null -> throw exception
 *
 * 3. Do I know to solve it?
 *         Yes- great is there an alternate ? yes
 *         No - can I break the problem into sub problems?
 *
 * 4. Ask for hint (if you don’t know how to solve this
 * 5.  Do I know alternate solutions as well
 *         Yes- what are those? solve using char array, string concatenation
 *         No- that is still fine, proceed to solve by what you know
 *
 * Simple technique brute force
 *
 * 6. If you know the alternate solution find out the O-notations (performance)
 * 7. Then, explain either both are the best (depends on the time)
 *         Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
 *         Approach 2: Write down the options and benefits and code the best
 * 8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
 *     -write the code
 * 9. Test against different test data
 * 10. If it fails then debug to solve it
 * 11. Optimize the code and remove unnecessary code
 */


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * problem:
 * Given a string return the reversed string
 * <p>
 * Eg:
 * input: hello world -> olleh dlrow
 * output: dlrow olleh
 */
public class ReverseString {

    @Test
    public void test() {
        String str = "hello world!";
        Assertions.assertEquals("!dlrow olleh", reverseStringTwoPointer(str));
    }


    public String reverseString(String str) {
        if (str == null) throw new RuntimeException("String can't be null");
        str = str.strip();
        String output = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            output += str.charAt(i);
        }
        return output;
    }

    public String reverseStringTwoPointer(String str) {
        if (str == null) throw new RuntimeException("String can't be null");
        str = str.strip();
        char[] charArray = str.toCharArray();
        StringBuffer output = new StringBuffer();
        int left=0, right=str.length()-1;
        while (left<right){
            char temp=  str.charAt(left); //charArray[left]
            charArray[left]=charArray[right];
            charArray[right]=temp;
            left++;
            right--;

        }
        for (int i=0;i<charArray.length;i++){
            output.append(charArray[i]);
        }
        return output.toString();
    }

}
