//TC: O(n)
//SC: O(n)


class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;

        int[] arr = new int[n];
        arr[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Math.min(n2, Math.min(n3, n5));
            arr[i] = min;
            if(n2 == min){
                p2++; n2 = arr[p2] * 2;
            }
            if(n3 == min){
                p3++; n3 = arr[p3] * 3;
            }
            if(n5 == min){
                p5++; n5 = arr[p5] * 5;
            }
        }
        return arr[n-1];
    }
}