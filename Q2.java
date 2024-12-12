Time Complexity (TC): O(n)
Space Complexity (SC): O(n)
class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int uglyNum2=arr[p2]*2;
            int uglyNum3=arr[p3]*3;
            int uglyNum5=arr[p5]*5;
            int newUglyNum=Math.min(uglyNum2,Math.min(uglyNum3,uglyNum5));
            arr[i]=newUglyNum;
            if(newUglyNum==uglyNum2)p2++;
            if(newUglyNum==uglyNum3)p3++;
            if(newUglyNum==uglyNum5)p5++;
        }

        return arr[n];
    }
}
