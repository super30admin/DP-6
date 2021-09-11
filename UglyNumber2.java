// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int nthUglyNumber(int n) {
       if(n == 1)
            return 1;
        int p1 = 0, p2 = 0, p3 = 0;
        int n1 = 2, n2 = 3, n3 = 5;
        int[] res = new int[n];
        res[0] = 1;
        int min = 1;
        for(int i = 1; i < n; i++){
            min = Math.min(n1, Math.min(n2, n3));
            res[i] = min;
            if(n1 == min){
                p1++;
                n1 = res[p1] * 2;
            }
             if(n2 == min){
                p2++;
                n2 = res[p2] * 3;
            }
            if(n3 == min){
                p3++;
                n3 = res[p3] * 5;
            }
        }
        return res[n - 1];
    }
}