class Solution {
    public int nthUglyNumber(int n) {
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> q = new PriorityQueue<>();
        int i = 0;
        long ugly = 1L;
        q.add(ugly);
        set.add(ugly);
        int[] primes = new int[] {2,3,5};
        while(i<n){
            ugly=q.poll();
            for(int prime : primes){
                long temp = prime*ugly;
                if(!set.contains(temp)){
                    set.add(temp);
                    q.add(temp);
                }
            }
        i++;
        }

    return Math.toIntExact(ugly);
    }
}