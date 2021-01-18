//Time Complexity - O(n)
//Space Complexity - O(1)

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1){
            return 1;
        } 
        int[] arr = new int[n + 1];
        int p2 = 0; int p3 = 0; int p5 = 0;
        int n2 = 2; int n3 = 3; int n5 = 5;
        arr[0] = 1;
        for(int i = 1; i <= n; i++){
            int min = Math.min(n2, Math.min(n3, n5));
            arr[i] = min;
            if(min == n2){
                p2++;
                n2 = arr[p2] * 2;
            }
            if(min == n3){
                p3++;
                n3 = arr[p3] * 3;
            }
            if(min == n5){
                p5++;
                n5 = arr[p5] * 5;
            }         
        }
        return arr[n-1];      
    }
}