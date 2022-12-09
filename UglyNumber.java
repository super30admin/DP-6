//Time - O(n)
//Space -O(n)
class Solution {
    public int nthUglyNumber(int n) {
        int n1 = 2;
        int n2 = 3;
        int n3 = 5;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int[] arr = new int[n];
        arr[0] =1;
        for(int i=1; i<n; i++){
            int min = Math.min(n1, Math.min(n2,n3));
            arr[i] = min;
            if(min == n1){
                i1++;
                n1 = 2*arr[i1];
            }
            if(min == n2){
                i2++;
                n2 = 3*arr[i2];

            }
            if(min == n3){
                i3++;
                n3 = 5*arr[i3];

            }
        }
        return arr[n-1];

    }
}