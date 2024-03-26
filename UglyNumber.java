class Solution {
    //TC: O(n)
    //SC: O(n)
    //3 pointers
    public int nthUglyNumber(int n) {
       int [] arr = new int[n];
       arr[0] = 1;
       int p2 = 0, p3 = 0, p5 = 0;
       int n2 = 2, n3 = 3, n5 = 5;
       for(int i = 1; i <n; i++){
         int min = Math.min(n2, Math.min(n3,n5));
         arr[i] = min;
         if(n2 == min){
                p2++;
                n2 = 2*arr[p2];
         }
         if(n3 == min){
                p3++;
                n3 = 3*arr[p3];
         }
         if(n5 == min){
                p5++;
                n5 = 5*arr[p5];
         }

       }
       return arr[n-1];
    }
}
