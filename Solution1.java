// Time complexity: O(n)
// Space Complexity: O(1)

class Solution1 {
    public int nthUglyNumber(int n) {
        //null case
        if( n == 1) {
            return 1;
        }
        int p2 = 0, p3 = 0, p5 = 0;
        int[] result = new int[n];
        result[0] = 1;
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        for(int i = 1; i < n; i++) {
            int min = Math.min(n2, Math.min(n3, n5));
            if( min == n2 ) {
                p2++;
                result[i] = min;
                n2 = 2 * result[p2];
            }
            if( min == n3 ) {
                p3++;
                result[i] = min;
                n3 = 3 * result[p3];
            }
            if( min == n5 ) {
                p5++;
                result[i] = min;
                n5 = 5 * result[p5];
            }
        }
        return result[n-1];
    }
}