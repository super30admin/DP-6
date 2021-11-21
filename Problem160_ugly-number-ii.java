// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        int[] result = new int[n]; // pointers p2, p3, p5 uses this array
        result[0] = 1;
        // int min = -1;;
        for(int i = 1; i < n; i++) {
            int min = Math.min(n2, Math.min(n3, n5));
            result[i] = min;
            if(min == n2) {
                p2++;
                n2 = result[p2] * 2;
            }
            if(min == n3) {
                p3++;
                n3 = result[p3] * 3;
            } 
            if(min == n5) {
                p5++;
                n5 = result[p5] * 5;
            }
        }
        return result[n - 1];
        // return min;
    }
}