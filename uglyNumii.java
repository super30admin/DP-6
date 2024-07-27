
// Using DP solution
class Solution {
    public int nthUglyNumber(int n) {
        // Tc: O(n) Sc: O(n)
        int res[] = new int[n];
        res[0] = 1;

        int ind2 = 0;
        int ind3 = 0;
        int ind5 = 0;

        int fact2 = 2;
        int fact3 = 3;
        int fact5 = 5;

        for (int i = 1; i < n; i++) {
            int minim = Math.min(fact2, Math.min(fact3, fact5));
            res[i] = minim;

            if (fact2 == minim) {
                ind2++;
                fact2 = 2 * res[ind2];
            }

            if (fact3 == minim) {
                ind3++;
                fact3 = 3 * res[ind3];
            }

            if (fact5 == minim) {
                ind5++;
                fact5 = 5 * res[ind5];
            }
        }
        return res[n - 1];
    }

}

// TLE Solution

/*
 * class Solution {
 * public int nthUglyNumber(int n) {
 * int num = 1;
 * int cnt = 0;
 * 
 * while (cnt < n) {
 * if (isUgly(num))
 * cnt++;
 * 
 * if (cnt < n)
 * num++;
 * }
 * return num;
 * }
 * 
 * private boolean isUgly(int num) {
 * if (num <= 0)
 * return false;
 * int[] divisors = { 2, 3, 5 };
 * for (int div : divisors) {
 * while (num % div == 0) {
 * num /= div;
 * }
 * }
 * 
 * return num == 1;
 * }
 * }
 * 
 */