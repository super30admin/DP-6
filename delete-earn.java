/*Time Complexity : O(N+W)
Space Complexity : O(N)
Did it run on leetcode : Yes
Any problems? No
*/


class Solution {
    public int deleteAndEarn(int[] nums) {
        int [] values = new int[10001];
        for(int i:nums)
        {
            values[i]=values[i]+i;  // Keep the total for each occurrence of a number.
        }
        
        int skip=0; int take= 0;    //2 variables are created to keep a check if we choose a number or not.
        
       for(int i=0;i<10001;i++)
       {
            int curr_take = skip + values[i];
            int curr_skip = Math.max(skip, take);
            take = curr_take;
            skip = curr_skip;
       }
       
        return Math.max(take,skip);
    }
}
