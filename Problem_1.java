// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Form the array of n+1 to set the ugly number in it, find a, b, c where a = arr[idx2]*2, b= arr[idx3]*3, c = arr[idx5]*5, initialy declare all the idx2,3,5 to 1 and set the arr[1] = 1. and find the min among all a, b,c and set it to the arr[i] = min, and if min == a then idx2++, if min == b them idx3++, if min == c then idx5++; and at the end return arr[n]
// Your code here along with comments explaining your approach
class Solution {
    public int nthUglyNumber(int n) {
        int [] arr = new int [n+1];
        arr[1] = 1;
        int idx2 = 1;
        int idx3 = 1;
        int idx5 = 1;
        for(int i = 2; i < n+1; i++){
            int a = arr[idx2]*2;
            int b = arr[idx3]*3;
            int c = arr[idx5]*5;
            int max = Math.min(a, Math.min(b,c));
            arr[i] = max;
            //System.out.println(arr[i]);
            if(max == a) idx2++;
            if(max == b) idx3++;
            if(max == c) idx5++;
        }
        return arr[n];
    }
}
