// Approach: Best: 3 pointers and a fixed size array of length n.
// Time: O(n)
// Space: O(1)

class UglyNumber_2 {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int[] result = new int[n];
        result[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2*result[p2], n3 = 3*result[p3], n5 = 5*result[p5];

        for (int i = 1; i<n; i++) {
            int min = Math.min(n2, Math.min(n3,n5));
            result[i] = min;

            if (min == n2) {
                p2++;
                n2 = 2*result[p2];
            }
            if (min == n3) {
                p3++;
                n3 = 3*result[p3];
            }
            if (min == n5) {
                p5++;
                n5 = 5*result[p5];
            }
        }
        return result[n-1];
    }
}