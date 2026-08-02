package week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {

    @Test
    public void test() {
        String s = "([])";
        Assertions.assertTrue(isValid(s));
    }

    @Test
    public void test1() {
        String s = "{(}[])";
        Assertions.assertFalse(isValid(s));
    }

    @Test
    public void test2() {
        String s = "()[]{}{()}";
        Assertions.assertTrue(isValid(s));
    }

    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && map.containsKey(ch) && map.get(ch) == stack.peek()) {
                stack.pop();
            } else stack.push(ch);
        }
        return stack.isEmpty();
    }
}
