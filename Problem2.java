//Time Complexity : O(n)
//Space Complexity : O(n)
// Worked on LeetCode : Yes

// Approach :
// 1. Since first  ugly numbers is . return n if n<=1.
// 2. Now have an array of size n. Fill first element with 1 .Have pointer for 2,3,5 on indexes 0,0,0.
// 3. Now find product of each prime(2,3,5) with dp[i] and find min and update the pointer for which minimum is found.
//    If multiple primes have same min value update pointers for all primes which have min value . Do this n times and 
//    return dp[n-1] as it will have nth ugly number.
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int i = 0,j = 0,k = 0;
        dp[0] = 1;
        for(int a = 1;a<n;a++){
            int x = 2*dp[i];
            int y = 3*dp[j];
            int z = 5*dp[k];
            dp[a] = Math.min(x,Math.min(y,z));
            if(dp[a] == x){
                if(x == y)  j++;
                if(x == z)  k++;
                i++;
            }
            else if(dp[a] == y){
                if(y == z)  k++;
                j++;
            }
            else    k++;
        }
        return dp[n-1];
    }
}
