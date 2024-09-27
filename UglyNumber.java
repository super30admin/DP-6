
//Approach is element is prime no when its only multiple are 2,3 and 5.
//so we will iterate for every no starting from 1 till n and multiply  by 2,3,5 and whichever is minimum we will consider as next element and move forward.
//return element at the end of iteration.

//time complexity o(n)
//space complexity is o(n)

import java.util.TreeSet;

public class UglyNumber {
	
	//using array
	public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        nums[0] = 1;
        for(int i = 1; i < nums.length; i++){
            nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
            if(nums[i] == nums[index2] * 2)
                index2++;
            if(nums[i] == nums[index3] * 3)
                index3++;
            if(nums[i] == nums[index5] * 5)
                index5++;
        }
        return nums[n - 1];
    }
	
//using treeset
	    public int nthUglyNumberUsingTreeSet(int n) {
	        TreeSet<Long> ans = new TreeSet<>();
	        ans.add(1L);
	        for (int i = 0; i < n - 1; ++i) {
	            long first = ans.pollFirst();
	            ans.add(first * 2);
	            ans.add(first * 3);
	            ans.add(first * 5);
	        }
	        return ans.first().intValue();
	    }
	

}
