// The idea here is that the pointers p1, p2 and p3 are pointing to the array (arr).
// The n2, n3 and n5 are computed from taking the arr[p2] * 2, arr[p3]*3, and arr[p5]*5 respectively.
// the reason it is if and not else it is because there could be a chance that the n2 and/or n3 and/or n5 are same.
// If that's the case, then we don't want the duplicate number which was the min before.
// Time complexity = O(n)// no. of integers asked.
// Space complexity = O(1)// no hashmap or pq.
class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int p2 =0;
        int p3 =0;
        int p5 =0;
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        for(int i=1;i<n ;i++) {
            int min = Math.min(n2,Math.min(n3,n5));
            arr[i] = min;
            if(n2 == min) {
                p2++;
                n2 = arr[p2]* 2;
            }
            if(n3 == min) {
                p3++;
                n3 = arr[p3]* 3;
            }
            if(n5 == min) {
                p5++;
                n5 = arr[p5]* 5;
            }
        }
        return arr[n-1];
        
    }
}