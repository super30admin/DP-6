/*
Time Complexity - O(n) where is the input number n.
Space Complexity - O(n)
*/
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int nextMul2 = 2, nextMul3 = 3, nextMul5 = 5;
        int index2 = 1, index3 = 1, index5 = 1;

        ugly[0] = 1;
        for(int i = 1; i < n; i++) {
            ugly[i] = Math.min(nextMul2, Math.min(nextMul3, nextMul5));
            if(ugly[i] == nextMul2) 
                nextMul2 = ugly[index2++] * 2;
            if(ugly[i] == nextMul3)
                nextMul3 = ugly[index3++] * 3;
            if(ugly[i] == nextMul5)
                nextMul5 = ugly[index5++] * 5;
        }
        return ugly[n - 1];
    }
}
