// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Maintain 3 variables n2, n3 and n5 initially having values 2, 3, 5. Create a array of ugly number initially
/// having just 1. Maintains pointers p2, p3, p5 pointing to that 1, i.e, index 0. Now for i=1 to n, add the minimum of n2, n3 n5 to
/// result, increment the corresponding pointer of min number and update that number
class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        int arr[] = new int[n];
        arr[0] = 1;
        for(int i=1;i<n;i++){
            int min = Math.min(n2, Math.min(n3, n5));
            arr[i] = min;
            if(n2 == min){
                p2++;
                n2 = arr[p2]*2;
            }
            if(n3 == min){
                p3++;
                n3 = arr[p3]*3;
            }
            if(n5 == min){
                p5++;
                n5 = arr[p5]*5;
            }
        }
        return arr[n-1];
    }
}