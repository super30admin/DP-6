/*Time Complexity: O(N log n)

Space Complexity: O(N)

Did this code successfully run on Leetcode : Yes

Approach: Using hashset to avoid repeatitions and priority queue to take care of the order.

Prob: 264. Ugly Number II
*/

import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public int nthUglyNumber(int n) {
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int count = 0;
        long currUgly = 1l;
        set.add(1l); pq.add(1l);
        int [] primes = new int[]{2,3,5};
        while(count != n){
            currUgly = pq.poll();
            count++;
            for(int prime : primes){
                long newUgly = prime * currUgly;
                if(!set.contains(newUgly)){
                    set.add(newUgly);
                    pq.add(newUgly);
                }
            }
        }
        return (int)currUgly;
    }
}