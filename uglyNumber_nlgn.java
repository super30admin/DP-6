// Time Complexity : O(n*lgn) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class uglyNumber_nlgn {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        int i = 1;
        long ugly = 1;
        pq.add(ugly);
        set.add(ugly);
        int[] primes = new int[] {2,3,5};
        while (i <= n) {
            ugly = pq.poll();
            set.remove(ugly);
            for (int prime : primes) {
                long temp = prime * ugly;
                if (!set.contains(temp)) {
                    set.add(temp);
                    pq.add(temp);
                }
            }
            i++;
        }
        return Math.toIntExact(ugly);
    }
}