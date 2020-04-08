// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 3 pointer approach

class uglyNumber {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int p2 = 0, p3 = 0, p5 = 0, n2 = 2, n3 = 3, n5 = 5;
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(Math.min(n2, n3), n5);
            if (arr[i] == n2) {
                p2++;
                n2 = 2 * arr[p2];
            }
            if (arr[i] == n3) {
                p3++;
                n3 = 3 * arr[p3];
            }
            if (arr[i] == n5) {
                p5++;
                n5 = 5 * arr[p5];
            }
        }
        return arr[n-1];
    }
}