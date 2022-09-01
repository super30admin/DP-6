//TC : O(N * Log N)
//SC : O(N)

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        
        pq.add((long)1); set.add((long)1); // From 1 -> Generate 2,3,5 then 2 -> {} ,3 -> {}, 5-> {} like that 
        int res = 0;
        long l = 0;
        int[] facts = {2,3,5};
        while(res != n){
            l = pq.poll();
            res++;
            for(int i : facts){
                Long temp = i * l;
                if(!set.contains(temp))
                    pq.add(temp);
                    set.add(temp); 
                
            }
        }
        return (int)l;
    }
}
