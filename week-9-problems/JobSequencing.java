package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class JobSequencing {

    @Test
    public void test(){
        int[] deadlines={4,1,1,1}; //4
        int[] profits ={20, 10, 40, 30};
        Assertions.assertArrayEquals(new int[]{2, 60}, jobSequencing(deadlines, profits));
    }

    public int[] jobSequencing(int[] deadlines, int[] profits){
        int[][] jobs=new int[deadlines.length][2];
        for (int i=0;i<deadlines.length;i++){
            jobs[i]= new int[]{deadlines[i], profits[i]}; //{{4,20},{1,10},{1,40},{1,30}}
        }

        // sort the array, such that all the max profits in descending order
        Arrays.sort(jobs, (a,b)->b[1]-a[1]); //{{1,40},{1,30},{4,20},{1,10}}

        int maxDeadline= Integer.MIN_VALUE;
        for (int i=0;i<deadlines.length;i++){
            maxDeadline=Math.max(maxDeadline, deadlines[i]);  // 4
        }
        int[] scheduler= new int[maxDeadline+1]; // [0,0,1,1,0] // {4,60},{3,40},{4,30}
        int totalProfit=0, count=0;
        for (int i=0;i<jobs.length;i++){
            int deadline=jobs[i][0]; // {1,40} deadline=1, profit=40;
            for (int j=deadline;j>0;j--){
                if(scheduler[j]==0){
                    scheduler[j]=jobs[i][0];
                    totalProfit+=jobs[i][1];
                    count++;
                    break;
                }
            }
        }
        return new int[]{count, totalProfit};
    }
}
