// Time Complexity : O(n) n is the num passed to us
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// All the ugly number will be multiples of 2, 3 or 5
// We will have 3 pointers p2, p3 and p5
// All will point to 1st value of ugly no. initially
// Now we will multiply each pointer's ugly no. to the value it represents
// We will find the min among them,  and add to ugly array and increment the count
// Finally we will return the last value in the ugly array
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i = 1; i < n; i++){
            int next = Math.min(ugly[p2] * 2, Math.min(ugly[p3] * 3, ugly[p5] * 5));
            ugly[i] = next;
            if(next == ugly[p2] * 2)
                p2++;
            if(next == ugly[p3] * 3)
                p3++;
            if(next == ugly[p5] * 5)
                p5++;
        }
        return ugly[n-1];
    }
}