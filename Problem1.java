class Solution {
    public int nthUglyNumber(int n) {
        //TC: O(n)
        //SC: O(1)
        //Solved on LeetCode
        if(n == 1) return 1;
        int[] arr = new int[n];
        arr[0] = 1;
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int n1 = 2 * arr[0];
        int n2 = 3 * arr[0];
        int n3 = 5 * arr[0];
        int count = 1;
        while(count < n){
            int min = Math.min(n1, Math.min(n2, n3));
            arr[count] = min;
            count++;
            if(min == n1){
                p1++;
                n1 = arr[p1] * 2;
            }
            if(min == n2){
                p2++;
                n2 = arr[p2] * 3;
            }
            if(min == n3){
                p3++;
                n3 = arr[p3] * 5;
            }
        }
        return arr[n-1];
    }
}