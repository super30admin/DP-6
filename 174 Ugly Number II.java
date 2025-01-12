// Time Complexity : O(n⋅logn)
// Space Complexity : O(n+m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    //aesha
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        int[] prime = {2,3,5};
        long currugly =1 ;
        pq.add(currugly);
        set.add(currugly);
        while(n>0)
        {
            n--;
            currugly = pq.poll();
            for(int pr: prime)
            {
                long newugly = currugly * pr;
                 if(!set.contains(newugly))
                {
                    set.add(newugly);
                    pq.add(newugly);
                }
            }
        }
        return (int)currugly;
    }
}