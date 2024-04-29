// ## Problem1: (https://leetcode.com/problems/ugly-number-ii/)
// DP - Three Pointer
// Time: O(N)
// Space: O(N)
class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0]=1;

        // Three pointers
        int p2=0, p3=0, p5=0;

        // Corresponding ugly numbers to the three pointers
        int n2,n3,n5;

        for(int i=1;i<n;i++){
            n2 = 2*uglyNums[p2];
            n3 = 3*uglyNums[p3];
            n5 = 5*uglyNums[p5];

            // Get the min and update corresponding pointer
            int mini = Math.min(n2, Math.min(n3, n5));
            uglyNums[i] = mini;
            if(n2 == mini){
                p2++;
            }
            if(n3 == mini){
                p3++;
            }
            if(n5 == mini){
                p5++;
            }
        }

        return uglyNums[n-1];
    }
}