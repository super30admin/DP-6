//Time Complexity-O(n)
//Space Complexity-O(n)

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp=new int[n];
        int p2=0;
        int p3=0;
        int p5=0;
        int n2=2;
        int n3=3;
        int n5=5;
        dp[0]=1;
        int min=0;
        for(int i=1;i<n;i++)
        {
            min=Math.min(n2,Math.min(n3,n5));
            dp[i]=min;
            if(min==n2)
            {
                p2=p2+1;
                n2=2*dp[p2];
            }
            if(min==n3)
            {
                p3=p3+1;
                n3=3*dp[p3];
            }
            if(min==n5)
            {
                p5=p5+1;
                n5=5*dp[p5];
            }
            
        }
        return dp[n-1];        
    }
}