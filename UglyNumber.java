// Time Complexity : O(1) because of limited input
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class UglyNumber {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        int [] result = new int[n];
        result[0] = 1;
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        int idx  = 1;
        while(idx<n){
            int min = Math.min(n2, Math.min(n3,n5));
            result[idx] = min;
            idx++;
            if(min==n2){
                p2++;
                n2 = 2*result[p2];
            }
            if(min==n3){
                p3++;
                n3 = 3*result[p3];
            }
            if(min==n5){
                p5++;
                n5 = 5*result[p5];
            }
        }
        return result[n-1];
    }

}