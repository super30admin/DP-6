//Timecomplexity:-O(n).
//spacecomplexity:-O(n).

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp=new int[n];
        dp[0]=1;
        int pointer2=0;
        int pointer3=0;
        int pointer5=0;
        for(int i=1;i<n;i++){
            dp[i]=Math.min(dp[pointer2]*2,Math.min(dp[pointer3]*3,dp[pointer5]*5));// current ugly number will be min of three previous ugly numbers.
            if(dp[i]==dp[pointer2]*2){
                pointer2++;
            }
            if(dp[i]==dp[pointer3]*3){
                pointer3++;
            }                        //based on hint3 the respective pointers will increase only when current element is derived from previous pointer that is also an ugly number.
            if(dp[i]==dp[pointer5]*5){
                pointer5++;
            }
        }
        return dp[dp.length-1];
    }
}