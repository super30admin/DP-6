//TC:O(n)
//SC:O(n)

class Solution {
    public int nthUglyNumber(int n) {
        int [] arr = new int [n];
        if(n==1) return 1;
        arr[0]=1;
        int p2=0,p3=0,p5=0;
        int n2 = 2,n3 =3,n5=5;
        for(int i=1;i<n;i++){
            int min = Math.min(n2,Math.min(n3,n5));
            arr[i] = min;
            //System.out.println(arr[i]);
            if(min == n2){
                p2++;
                n2 = 2*arr[p2];
            }
            if(min == n3){
                p3++;
                n3 = 3*arr[p3];
            }
            if(min == n5){
                p5++;
                n5=5*arr[p5];
            }
        }
        return arr[n-1];
    }
} 