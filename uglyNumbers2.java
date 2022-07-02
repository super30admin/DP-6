//TC: O(N)
//SC: O(N)
class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;

        int[] result = new int[n];

        int p2=0;
        int p3=0;
        int p5=0;
        result[0] = 1;

        for(int i=1;i<n;i++){
            int tmp = Math.min(result[p2]*2,Math.min(result[p3]*3,result[p5]*5));
            result[i] = tmp;
            if(tmp == result[p2]*2)
                p2++;
            if(tmp == result[p3]*3)
                p3++;
            if(tmp == result[p5]*5)
                p5++;
        }
        return result[n-1];
    }
}