// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        int[] arr = new int[n];
        arr[0] = 1;
        for(int i = 1; i < n; i++){
            int mini = Math.min(n2,Math.min(n3,n5));
            if(mini == n2){
                arr[i] = n2;
                p2++;
                n2 = arr[p2]*2;
            }
            if(mini == n3){
                arr[i] = n3;
                p3++;
                n3 = arr[p3]*3;
            }
            if(mini == n5){
                arr[i] = n5;
                p5++;
                n5 = arr[p5]*5;
            }
        }
        return arr[n-1];
    }
}