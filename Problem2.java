//Time Complexity : O(n)
//Space Complexity : O(n)
// Worked on LeetCode : Yes

// Approach :
// 1. Since first  ugly numbers is 1. return n if n<=1.
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

// Brute Force Approach

//Time Complexity : O(n)
//Space Complexity : O(1)
// Worked on LeetCode : Time Limit Exceeded

// Approach :
// 1. Since first  ugly numbers is 1. return n if n<=1.
// 2. For each integer after 1 , check if it is an ugly number . Divide the number by 2, 3 and 5 . Do this till quotient 
//    is 1. Else it is not ugly. If it is ugly increment count. Do this till count equals n and return n.
class Solution {
    public int nthUglyNumber(int n) {
        int num = 1;
        int count = 1;
        int nugly = 1;
        while(count<n){
            num++;
            if(isUgly(num)) {
                nugly = num;
                count++;
            }
        }
        return nugly;
}
    public boolean isUgly(int num){
        if(num == 1)    return true;
        if(num%2 == 0)  num = num/2;
        else if(num%3 == 0)  num = num/3;
        else if(num%5 == 0)  num = num/5;
        else return false;
        return isUgly(num);
    }
}
