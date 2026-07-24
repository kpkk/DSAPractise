package week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstBadVersion {

    @Test
    public void test(){
        int n=5, bad=4;
        Assertions.assertEquals(4, firstBadVersion(n, bad));
    }

    public int firstBadVersion(int n, int bad) {

        int low=1, high=n;
        int ans=0;
        while(low<=high){
            int mid = low+(high-low)/2;
            boolean isBad = isBadVersion(mid, bad);
            if(isBad){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }

    public boolean isBadVersion(int n, int bad){
        if (n==bad) return true;
        else return false;
    }
}
