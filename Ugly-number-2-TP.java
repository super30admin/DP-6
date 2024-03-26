/*Time Complexity: O(N)

Space Complexity: O(N)

Did this code successfully run on Leetcode : Yes

Approach: Using three pointers (p2,p3,p5) and updating the numbers based on the min value of the numbers.

Prob: 264. Ugly Number II
*/

class Solution {
    public int nthUglyNumber(int n) {
        int [] arr = new int[n];
        int p2=0,p3=0,p5=0;
        int n2=2,n3=3,n5=5;
        arr[0] = 1;
        for(int i=1;i<n;i++){
            int min = Math.min(n2,Math.min(n3,n5));
            arr[i] = min;
            if(n2 == min){
                p2++;
                n2 = 2*arr[p2];
            }
            if(n3 == min){
                p3++;
                n3 = 3*arr[p3];
            }
            if(n5 == min){
                p5++;
                n5 = 5*arr[p5];
            }
        }
        return arr[n-1];
    }
}