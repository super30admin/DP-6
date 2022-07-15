/*
Problem: https://leetcode.com/problems/ugly-number-ii/
*/

// Approach 1: Slow
// TC: n log(k) where k is the number of elements in the queue
class Solution {
    public int nthUglyNumber(int n) {
        int count = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        long uglyNumber = 0;
        pq.add(1L);
        int primes[] = new int[]{2,3,5};
        
        while (count != n && !pq.isEmpty()) {
            uglyNumber = pq.poll();
            ++count;
            
            for (int i = 0; i < primes.length; ++i) {
                long newNumber = uglyNumber * primes[i];
                if (!set.contains(newNumber)) {
                    set.add(newNumber);
                    pq.add(newNumber);
                }
            }
        }
        return (int)uglyNumber;
    }
}

// Approach 2:
// TC: O(n)
// SC: O(n)
class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;
        
        int result[] = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        result[0] = 1;
        
        for (int i = 1; i < n; ++i) {
            int min = Math.min(n2, Math.min(n3, n5));
            // We have to update result here and not after all the ifs
            result[i] = min;
            
            if (n2 == min) {
                ++p2;
                n2 = result[p2] * 2;
            }
            if (n3 == min) {
                ++p3;
                n3 = result[p3] * 3;
            }
            if (n5 == min) {
                ++p5;
                n5 = result[p5] * 5;
            }
        }
        
        return result[n-1];
    }
}