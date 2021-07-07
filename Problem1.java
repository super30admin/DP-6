// Time Complexity : O(n+m)  n -> max possible value in given array , m-> size of given array
// Space Complexity : O(n) n -> max possible value in given array
// Worked on LeetCode : Yes
// 
// Approach 
// 1.Have an array of size equals to maximum possible value in array . Now for each element in given array , 
//   find the corresponding index in new array and add the current integer's value to the value already present.Do this for
//   all elements in array.
// 2. Now we initialise skip and take to 0 as we don't get any points either by taking or skipping 0. 
//    Now from index 1, if we take current value then we need to skip previous value .So add current value and previous indexe's
//    skipped value. Now if we skip current value then it is possible to either skip previous value or take previous value .
//    So take current skip value as max of previous skip and take values.
// 3. After going through all iterations return maximum of skip and take values.

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        for(int i:nums)
            dp[i]+=i;
        int skip = 0,take = 0;
        for(int i = 1;i<dp.length;i++){
            int takecurrent = skip+dp[i];
            int skipcurrent = Math.max(skip,take);
            take = takecurrent;
            skip = skipcurrent;
        }
        return Math.max(skip,take);
    }
}
