//time complexity-O(n)
//Space complexity-O(n)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int nthUglyNumber(int n) {
        int dp[]= new int[n];
        dp[0]=1;
        int p2=0,p3=0,p5=0;//three pointers in dp array 
        int n2=2,n3=3,n5=5;//initial numbers
        for(int i=1;i<n;i++){
            int min= Math.min(n2, Math.min(n3,n5));//2
            dp[i]=min;//n2 is the minimum here
            
            if(min==n2){
                p2++;//next index will point what factor to consider
                n2= dp[p2]*2;//updating n2
            }
            if(min==n3){
                p3++;
                n3=dp[p3]*3;
            }
            if(min==n5){
                p5++;
                n5=dp[p5]*5;
                
            }
        }
        return dp[n-1];
    }
}