// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1)
            return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        pq.add(1L);
        set.add(1L);
        int[] factors = new int[]{2,3,5};
        int count = 0;
        while(!pq.isEmpty()){
            long currUgly = pq.poll();
            count++;
            if(count == n)
                return (int)currUgly;
            for(int factor: factors){
                long newUgly = currUgly * factor;
                if(!set.contains(newUgly)){
                    pq.add(newUgly);
                    set.add(newUgly);
                }
            }
        }

        return 45678;
    }
}