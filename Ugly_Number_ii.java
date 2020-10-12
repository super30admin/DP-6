class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int i=1;
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
       
        long ugly = 1;
        set.add(ugly);
        pq.add(ugly);
        while(i <= n)
        {
            ugly = pq.poll();
        
            long n2 = ugly * 2;
            long n3 = ugly *3;
            long n5 = ugly * 5;
            if(!set.contains(n2))
            {
                set.add(n2);
                pq.add(n2);
            }
            if(!set.contains(n3))
            {
                set.add(n3);
                pq.add(n3);
            }
            if(!set.contains(n5))
            {
                set.add(n5);
                pq.add(n5);
            }
            
            i++;
        }
        return Math.toIntExact(ugly);
    }
}

//Time complexity: O(n log n)
//Space complexity: O(n) for the HashSet and Priority Queue.
