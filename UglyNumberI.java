// Take the priority queue as the option
// Time complexity = O(Nlog(N)). where N is the no. of elements in the priority queue which is going to be significantly higher than n.
// Space complexity = O(N). the priority queue.
// why did I take long, because if the ugly number asked is 1000, the integer will be so long as to overflow.
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();// min heap.
        // why min heap-> because I want to get the first n ugly number. Note the "first".
        Set<Long> set = new HashSet<>(); // visited set
        //kth size pq.
        int i=0;
        int[] primes = new int[]{2,3,5};
        pq.add(1l); // refer eg 2 .
        long currUgly =1l;
        while(i<n) {
            currUgly = pq.poll();
            i++;
            for(int prime: primes) {
                long newUgly = prime*currUgly;
                if(!set.contains(newUgly)) {
                    pq.add(newUgly);
                    set.add(newUgly);
                }
            }

        }

        return (int)currUgly;
        
    }
}