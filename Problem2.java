//Time Complexity : O(n)
//Space Complexity : O(n)
// Worked on LeetCode : Yes

// Approach :
// 1. Since first 5 ugly numbers are integers from 1 to 5 . return n if n<=5.
// 2. Now have an array of size n. Fill with i+1 from i=0 to i = 5.Have pointer for 2,3,5 on indexes 2,2,4.
// 3. Now find product of each prime(2,3,5) with dp[i] and find min and update the pointer for which minimum is found.
//    If multiple primes have same min value update pointers for all primes which have min value . Do this n times and 
//    return dp[n-1] as it will have nth ugly number.
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        if(n<=5)    return n;
        for(int i = 0;i<5;i++){
            dp[i] = i+1;
        }
        int i = 2;
        int j = 2;
        int k = 4;
        for(int a = 5;a<n;a++){
            int x = 2*dp[i];
            int y = 3*dp[j];
            int z = 5*dp[k];
            dp[a] = Math.min(x,Math.min(y,z));
            if(x == y && y == z){
                i++;
                j++;
                k++;
            }
            else if(dp[a] == x){
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
