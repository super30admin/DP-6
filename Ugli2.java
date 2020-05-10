//o(nlogn) time and o(n) space
//passed all leetcode cases
//used priority queue

class Solution {
    //List<Integer> pool = new ArrayList<Integer>();
    public int nthUglyNumber(int n) {

        if(n==1) return n;
        PriorityQueue<Long>pq  = new PriorityQueue<>();
        HashSet<Long>set = new HashSet<>();
        int i=1;
        long current = 1;
        pq.add(current);
        set.add(current);
        int[]primes = new int[]{2,3,5};
        while(i<=n){
            current = pq.poll();
            for(int p:primes){
                long temp = p*current;
                if(!set.contains(temp)){
                    set.add(temp);
                    pq.add(temp);
                }
            }
            i++;
        }

        return Math.toIntExact(current);

    }

}