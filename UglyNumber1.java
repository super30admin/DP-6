// Time Complexity : O(n log n)
// Space Complexity : O(n)

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1)
            return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        int[] primes = {2, 3, 5};
        pq.add(1L);
        int count = 0;
        long curUgly = 0;
        while(count < n){
            curUgly = pq.poll();
            count++;
            for(int prime: primes){
                long newUgly = curUgly * prime;
                if(!set.contains(newUgly)){
                    set.add(newUgly);
                    pq.add(newUgly);
                }
            }
        }
        return (int)curUgly;
    }
}