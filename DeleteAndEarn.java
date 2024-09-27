//Approach to store the numbers in another array at index = number so that we will identify  it's neighboring element
//for current index compute the sum without considering previous index and next index.
//select max sum between  previous index sum and current index sum.
//return last index sum.

//time complexity is o(n)
//space complexity is o(1)
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001]; 
        
        for(int i = 0; i < nums.length; i++){
            sum[nums[i]] += nums[i]; 
        }
        
        for(int i = 2; i < sum.length; i++){
            sum[i] = Math.max(sum[i-1], sum[i-2] + sum[i]);
        }
        return sum[10000];
    }

}
