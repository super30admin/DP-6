package dp6;

//TC: O(n) where n is the sequence number to find the value.
public class UglyNumber_2 {

public int nthUglyNumber(int n) {
        
        int[] dp = new int[n];
        dp[0] = 1;
        
        //int min;
        
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int multiply_2 = dp[0] * 2;
        int multiply_3 = dp[0] * 3;
        int multiply_5 = dp[0] * 5;
        
        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(multiply_2, multiply_3), multiply_5);
            
            if(dp[i] == multiply_2) {
                i2++;
                multiply_2 = dp[i2] * 2;
            }
            if(dp[i] == multiply_3) {
                i3++;
                multiply_3 = dp[i3] * 3;
            }
            if(dp[i] == multiply_5) {
                i5++;
                multiply_5 = dp[i5] * 5;
            }
        }
        return dp[n - 1];
    }
    
    /*
    //BRUTE FORCE
    //Time Limit Exceeded
    public int nthUglyNumber(int n) {
        int count = 1, i = 1;
        while(count < n) {
            i++;
            if(isUgly (i)) count++;
        }
        return i;
    }
    
    private int maxDivide(int a, int b) {
            while(a % b == 0) {
                a = a / b;
            }
            return a;
        }
    
    private boolean isUgly(int a) {
        a = maxDivide(a, 2);
         a = maxDivide(a, 3);
         a = maxDivide(a, 5);
        
        if(a == 1) return true;
        return false;
    }
    */
	
}
