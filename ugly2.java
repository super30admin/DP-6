//Time Complexity: O(n) - We loop n times to compute up to the nth ugly number.
//Space Complexity: O(n) – We store the sequence in an array of size n.

//Build an array arr of ugly numbers, starting with 1, and track three indices p2,p3,p5 for multiples of 2, 3, and 5.
//At each step, set arr[i] = min(arr[p2]*2, arr[p3]*3, arr[p5]*5).
//Advance any pointer(s) whose multiple matched the chosen min, updating their next candidate to avoid duplicates.

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
