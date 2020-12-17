// Time Complexity : O(1690)
// Space Complexity : O(1690) 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// use 3 pointers, produce multiples of 2,3,5 which ever is min put in next index, keep building till n and return

class Ugly {
    public int[] nums = new int[1690];
    Ugly() {
      nums[0] = 1;
      int ugly, i2 = 0, i3 = 0, i5 = 0;
  
      for(int i = 1; i < 1690; ++i) {
        ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
        nums[i] = ugly;
  
        if (ugly == nums[i2] * 2) ++i2;
        if (ugly == nums[i3] * 3) ++i3;
        if (ugly == nums[i5] * 5) ++i5;
      }
    }
  }
  
  class Solution {
    public static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
      return u.nums[n - 1];
    }
  }