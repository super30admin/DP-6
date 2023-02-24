//https://leetcode.com/problems/ugly-number-ii
//TC : O(N)
//SC : O(N)
//N - number of elements form by the factors . N > n ( input )

class Solution {
    public int nthUglyNumber(int n) {
        if(n==1)return 1;
        int [] factors = new int[]{2,3,5};
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.add(1L);
        set.add(1L);
        int count = 0;
        while(!pq.isEmpty()){
            long curr = pq.poll();
            count++;
            if(count == n) return (int)curr;
            for(int factor : factors){
                long newUgly = (Long) (curr * factor);
                if(!set.contains(newUgly)){
                    pq.add(newUgly);
                    set.add(newUgly);
                }
            }
        }
        return 13;
    }
}
