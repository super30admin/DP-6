import java.util.HashSet;
import java.util.PriorityQueue;

// Time Complexity : O(N log N)  -> N is the numbers in pq which is greater than n.
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

public class UglyNumberUsingPQ {
    public int nthUglyNumber(int n) {
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> q = new PriorityQueue<>();

        int[] ugly = new int[]{2,3,5};
        q.add(1L);
        set.add(1L);

        for(int i=1; i<n; i++){
            long currUgly = q.poll();
            for(int num: ugly){
                long newUgly = currUgly * num;
                if(!set.contains(newUgly)){
                    set.add(newUgly);
                    q.add(newUgly);
                }
            }
        }

        return (int)(long) q.poll();
    }
}
