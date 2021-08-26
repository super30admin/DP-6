# DP-6
    
## Problem1: (https://leetcode.com/problems/ugly-number-ii/)
//Time Complexity = O(N)
//Space Complexity = O(1)
class Solution {
    public int nthUglyNumber(int n) {
        int[] result = new int[n]; 
        int p2 = 0; 
        int p3 = 0; 
        int p5 = 0; 
        int n2 = 2; 
        int n3 = 3; 
        int n5 = 5;
        result[0] = 1;
        for(int i = 1; i < n; i++)
        {
            int min = Math.min(n2, Math.min(n3,n5)); 
            result[i] = min; 
            if(n2 == min){
                p2++; 
                n2 = 2 * result[p2]; 
            }
            if(n3 == min){
                p3++;
                n3 = 3 * result[p3]; 
            }
            if(n5 == min){
                p5++;
                n5 = 5 * result[p5]; 
            }
        }
        
        return result[n - 1];
    }
}
   
## Problem2: (https://leetcode.com/problems/longest-palindromic-substring/)

