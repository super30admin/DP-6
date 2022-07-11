// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int nthUglyNumber(int n) {
        
        if(n < 2) {
            return n;
        }
        
        int[] arr = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        
        arr[0] = 1;
        
        for(int i = 1; i < n; i++) {
            int min = Math.min(n2, Math.min(n3, n5));
            
            arr[i] = min;
            
            if(min == n2) {
                n2 = arr[++p2] * 2;
            }
            
            if(min == n3) {
                n3 = arr[++p3] * 3;
            }
            
            if(min == n5) {
                n5 = arr[++p5] * 5;
            }
        }
        
        return arr[n - 1];
    }
}