package week9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DIMatchString {

    @Test
    public void test(){
        String s="IDID";
        Assertions.assertArrayEquals(new int[]{0,4,1,3,2}, diStringMatch(s));
    }

    public int[] diStringMatch(String s){
        int left=0, right=s.length();
        int[] ans= new int[s.length()+1];
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='I') ans[i]=left++;
            else ans[i]=right--;
        }
        ans[ans.length-1]=left;
        return ans;
    }
}
