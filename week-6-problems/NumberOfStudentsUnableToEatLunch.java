package week6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class NumberOfStudentsUnableToEatLunch {

    @Test
    public void test(){
        int[] students={1,1,0,0}, sandwiches={0,1,0,1};
        Assertions.assertEquals(0, countStudents(students, sandwiches));
    }

    @Test
    public void test1(){
        int[] students={1,1,1,0,0,1}, sandwiches={1,0,0,0,1,1};
        Assertions.assertEquals(3, countStudents(students, sandwiches));
    }

    public int countStudents(int[] students, int[] sandwiches){
        ArrayDeque<Integer> sq = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<students.length;i++){
            sq.add(students[i]);
            stack.push(sandwiches[students.length-i-1]);
        }
        int lastServed=0;
        while (!sq.isEmpty() && lastServed < sq.size()){
            if(sq.peek() == stack.peek()){
                sq.poll();
                stack.pop();
                lastServed=0;
            }else {
                Integer remove = sq.poll();
                sq.add(remove);
                lastServed++;
            }
        }
        return lastServed;
    }
}
