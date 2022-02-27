// Time Complexity : O(n log k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Approach 1: Using HashSet and min heap/priority queue, when the count equals n, we return the popped value from min heap
class Solution {
    public int nthUglyNumber(int n) {
        if (n==1) return 1;
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue();
        int[] primes = new int[]{2,3,5};

        // add first values to set and min heap
        set.add((long)1);
        pq.add((long)1);
        long curr=0;

        while (n>0) {
            curr = pq.poll();
            for (int prime: primes) {
                long newNum = prime*curr;
                if (!set.contains(newNum)) {
                    set.add(newNum);
                    pq.add(newNum);
                }
            }
            n--;
        }

        return (int)curr;
    }
}

// Approach 2:
// Time Complexity : O(n)
// Space Complexity : O(n)

// Approach 2: We use 3 pointers and 3 numbers, we iterate from 1 to n, and we calculate the min among n2,n3 and n5 and
// then we increment the corresponding pointer and update the number: result[corresponding-pointer] * (2 | 3 | 5) based
// on the min number and Return the last element in the array
class Solution {
    public int nthUglyNumber(int n) {
        if (n==1) return 1;

        int[] result = new int[n];
        result[0] = 1;
        int n2=2, n3=3, n5=5;
        int p2=0, p3=0, p5=0;

        for (int i=1; i<n; i++) {
            int min = Math.min(n2, Math.min(n3, n5));
            result[i] = min;

            // check what gave you the min
            if (n2 == min) {
                p2++;
                n2 = result[p2] * 2;
            }
            if (n3 == min) {
                p3++;
                n3 = result[p3] * 3;
            }
            if (n5 == min) {
                p5++;
                n5 = result[p5] * 5;
            }
        }

        return result[n-1];
    }
}