// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;

        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;

        for(int i = 1; i < n; i++) {
            arr[i] = Math.min(n2, Math.min(n3, n5));

            if(arr[i] == n2) {
                p2++;
                n2 = arr[p2] * 2;
            }

            if(arr[i] == n3) {
                p3++;
                n3 = arr[p3] * 3;
            }

            if(arr[i] == n5) {
                p5++;
                n5 = arr[p5] * 5;
            }
        }

        return arr[n - 1];
    }
}
