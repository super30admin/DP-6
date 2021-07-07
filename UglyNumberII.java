

class Solution {
    public int nthUglyNumber(int n) {
        
        int[] dp = new int[n];
        
        dp[0]= 1;
        
        int i_2=0;int i_3=0; int i_5=0;  // indexes to the dp array
        int m2=2; int m3 =  3; int m5=5;
        
        for(int x = 1; x< n; x++){
            dp[x] = Math.min(m2,Math.min(m3,m5));
            
            if(dp[x] == m2){
                i_2++;
                m2= 2*dp[i_2];
            }
            if(dp[x] == m3){
                i_3++;
                m3= 3*dp[i_3];
            }
            if(dp[x] == m5){
                i_5++;
                m5= 5*dp[i_5];
            }
        }
        return dp[n-1];
        
    }
}
