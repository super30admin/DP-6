// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int nthUglyNumber(int n) {
        //pointers
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        //values
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        int[] result = new int[n];
        result[0] = 1;
        //Loop will run until we get the nth number
        for(int i=1; i<n; i++){
            int min = Math.min(n2, Math.min(n3, n5));
            result[i] = min;
            if(min == n2){
                p2++;
                n2 = 2 * result[p2];
            }
            if(min == n3){
                p3++;
                n3 = 3 * result[p3];
            }
            if(min == n5){
                p5++;
                n5 = 5 * result[p5];
            }

        }

        return result[n-1];
    }
}