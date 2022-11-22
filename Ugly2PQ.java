class Solution {
    //tc-nlogk sc-o()
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int[]primes = new int[]{2,3,5};
        HashSet<Long> set = new HashSet<>();
        long curr = 1L;
        set.add(curr);
        pq.add(curr);
        while(n!=0)
        {
            curr = pq.poll();
            n--;
            for(int i=0;i<3;i++)
            {
               long newnum =curr*primes[i];
               if(!set.contains(newnum))
               {
               set.add(newnum);
               pq.add(newnum);
               }

            }

        }
        return (int)curr;
    }
}