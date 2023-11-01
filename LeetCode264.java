// Time Complexity : O(n) 
// Space Complexity : O(n) result array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] result = new int[n];
        result[0] =1;
        int p2=0,p3=0,p5=0;
        int n2=2,n3=3,n5=5;
        for(int i=1;i<n;i++){   // form the ugly numbers yourself and maintain increasing order using min.
            int min = Math.min(n2, Math.min(n3,n5));
            result[i]=min;
            if(n2==min){
                p2++;
                n2= 2*result[p2]; 
            }
            if(n3==min){
                p3++;
                n3= 3*result[p3];
            }
            if(n5==min){
                p5++;
                n5= 5*result[p5];
            }
        }
        return result[n-1];
    }
}