// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
we are using 2 pointer approach, p2,p3,p5 are pointers and n2,n3,n5 are
values on each itteration we take MIN(n2,n3,n5)
which ever number  get we store at ith place
we increase its pointer and update that 'n'  using px*arr[p];
*/

class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Math.min(n2, Math.min(n3, n5));
            arr[i] = min;
            if (min == n2) {
                p2++;
                n2 = 2 * arr[p2];
            }
            if (min == n3) {
                p3++;
                n3 = 3 * arr[p3];
            }
            if (min == n5) {
                p5++;
                n5 = 5 * arr[p5];
            }
        }
        return arr[n - 1];
    }
}