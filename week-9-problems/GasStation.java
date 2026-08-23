package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GasStation {

    @Test
    public void test() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        Assertions.assertEquals(3, canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;
        for (int i=0;i<cost.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalGas<totalCost) return -1;
        int start=0;
        int net=0;
        for (int i=0;i<gas.length;i++){
            net+=gas[i]-cost[i];  //3+3
            if(net<0){
                net=0;
                start=i+1;
            }
        }

        return start;
    }
}
