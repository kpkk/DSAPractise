package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LemonadeChange {

    @Test
    public void test(){
        int[] bills={5,5,5,10,20};
        Assertions.assertTrue(lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills){
        int fiveCount=0;
        int tensCount=0;
        int twentyCount=0;
        for (int i=0;i<bills.length;i++){
            if(bills[i]==5)
                fiveCount++;
            else if(bills[i]==10){
                if(fiveCount>0){
                    fiveCount--;
                    tensCount++;
                }
                else return false;
            }else {
                if(tensCount>0 && fiveCount>0){
                    tensCount--;
                    fiveCount--;
                    twentyCount++;
                }
                else if (fiveCount>=3){
                    fiveCount-=3;
                    twentyCount++;
                }
                else return false;
            }
        }
        return true;
    }
}
