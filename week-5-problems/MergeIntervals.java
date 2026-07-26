package week5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MergeIntervals {

    @Test
    public void test() {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        Assertions.assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, mergeIntervals(intervals));
    }

    @Test
    public void test1() {
        int[][] intervals = {{4, 7}, {1, 4}};
        Assertions.assertArrayEquals(new int[][]{{1, 7}}, mergeIntervals(intervals));
    }

    /**
     * First sort all the intervals by the start time
     * consider the first interval co-ordinate as the base reference
     * - startTime-> intervals[0][0]
     * - endTime->intervals[0][1]
     * iterate th array from index -> 1, till end
     * compare the end time of prev meeting with the current meeting startTime (which means an overlap)
     * - if there is an overlap,
     * - keep the start time as is
     * - endTime gets updated the interval thats on the higher side (take max between two endtimes)
     * - else
     * - add the start and endtimes to the list, as they are independent
     * - now update the start and enTimes with new values
     * add the start time and end times to the list, what ever is present
     * return the list of meetings or array of meetings
     *
     * @param intervals
     * @return
     */

    public int[][] mergeIntervals(int[][] intervals) {
        //{1, 3}, {1, 6} 3-6=>-3
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return (a[0] - b[0]);
            else return (a[1] - b[1]);
        });
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int startTime = intervals[0][0];
        int endTime = intervals[0][1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= endTime) {
                endTime = Math.max(endTime, intervals[i][1]);
            } else {
                list.add(Arrays.asList(startTime, endTime));
                startTime = intervals[i][0];
                endTime = intervals[i][1];
            }
        }
        list.add(Arrays.asList(startTime, endTime));

        int[][] output= new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            output[i][0]=list.get(i).get(0);
            output[i][1]=list.get(i).get(1);
        }

        return output;
    }
}
