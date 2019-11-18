package dp6;

//TC: O(m+n) where m and n is the length of nums and values array respectively.
//SC: O(n) where n is the length of values array.

public class DeleteAndEarn {

public int deleteAndEarn(int[] nums) {
        
        int n = 10001;
        int[] values = new int[n];
        
        for(int num : nums) {
            values[num] = values[num] + num;
        }
        
        int take = 0, skip = 0;
        
        for(int i = 0; i < n; i++) {
            int takei = values[i] + skip;
            int skipi = Math.max(skip, take);
            
            take = takei;
            skip = skipi;
        }
        return Math.max(take, skip);
    }
	
}
