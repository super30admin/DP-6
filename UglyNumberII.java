// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return n;

        long[] result = new long[1695];
        result[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int count = 1;
        while(count < n) {
        	result[count] = Math.min(
        		Math.min(result[i2] * 2, result[i3] * 3),
        		result[i5] * 5);
        	if(result[count] == result[i2] * 2) {
        		i2++;
        	}
        	if(result[count] == result[i3] * 3) {
        		i3++;
        	}
        	if(result[count] == result[i5] * 5) {
        		i5++;
        	}

        	count++;
        }

        return Math.toIntExact(result[n-1]);
    }
}