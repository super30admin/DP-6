class Solution {
    //tc-o(n) sc-o(n)
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] result = new int[n];
        result[0] = 1;
        int p2=0,p3=0,p5=0;
        int n2=2;
        int n3=3;int n5=5;
        for(int i=1;i<n;i++)
        {
            int min = Math.min(n2, Math.min(n3,n5));
            result[i] = min;
            if(n2==min)
            {
                p2++;
                n2=2*result[p2];         
            }
            if(n3==min)
            {
                p3++;
                n3=3*result[p3];
            }
             if(n5==min)
            {
                p5++;
                n5=5*result[p5];
            }   

        }
    return result[n-1];




    }
}