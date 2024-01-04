// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class UglyNumberTwo {
    class Solution {
        public int nthUglyNumber(int n) {
        /*Consider 3 pointers starting at 0th idx
        3 vars for 2, 3, 5
        select min of 3 vars and increment its corresponding ptr
        maintain an array to store ugly no. and ptrs to ref*/

            int ptr2 = 0, ptr3 = 0, ptr5 = 0;
            int n2 = 2, n3 = 3, n5 = 5;
            int ugly[] = new int[n];
            ugly[0] = 1;

            for(int i = 1; i < n; i++){
                int min = Math.min(n2, Math.min(n3, n5));
                ugly[i] = min;

                if(min == n2){
                    ptr2++;
                    n2 = 2 * ugly[ptr2];
                }

                if(min == n3){
                    ptr3++;
                    n3 = 3 * ugly[ptr3];
                }

                if(min == n5){
                    ptr5++;
                    n5 = 5 * ugly[ptr5];
                }
            }

            return ugly[n-1];
        }
    }
}
