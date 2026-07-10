package week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DietPlanPerformance {

    @Test
    public void test() {
        int[] calories = {1, 2, 3, 4, 5};
        int k = 1, lower = 3, upper = 3;
        Assertions.assertEquals(0, findCalories(calories, k, lower, upper));
    }

    @Test
    public void test1() {
        int[] calories = {3, 2};
        int k = 2, lower = 0, upper = 1;
        Assertions.assertEquals(1, findCalories(calories, k, lower, upper));
    }

    @Test
    public void test2() {
        int[] calories = {6, 5, 0, 0};
        int k = 2, lower = 1, upper = 5;
        Assertions.assertEquals(0, findCalories(calories, k, lower, upper));
    }

    /**
     * initialise integer variables called points=0, cals=0
     * iterate the array from start till k as we need to look up for window days
     * compare the calories were with lower and upper bounds
     * - if less than lower than decrement points
     * - if greater than upper increment points
     * iterate the array from k till end
     * add up the calories of i into cals
     * to maintain the window deduct the calories[i-k] from cals, to make sure that we are well within the window
     * Compare the cals with upper and lower bounds as we iterate till the end
     * return points
     * TC: O(n)
     * SC: O(1)
     *
     * @param calories
     * @param k
     * @param lower
     * @param upper
     * @return
     */

    public int findCalories(int[] calories, int k, int lower, int upper) {
        int points = 0, cals = 0;
        for (int i = 0; i < k; i++) {
            cals += calories[i];
        }
        if (cals < lower) points -= 1;
        else if (cals > upper) points += 1;
        for (int i = k; i < calories.length; i++) {
            cals += calories[i];
            cals -= calories[i - k];
            if (cals < lower) points -= 1;
            else if (cals > upper) points += 1;
        }
        return points;
    }
}
