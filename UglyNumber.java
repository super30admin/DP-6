import java.util.HashSet;
import java.util.PriorityQueue;
//Use a min-heap to get the minimum element and multiply by 2,3 and 5 
//and add new numbers to the heap skip the duplicates using hash set
//Time Complexity: O(nlogm)
//Space Complexity: O(m)
public class UglyNumber {
    public int nUglyNumber(int n)
    {
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> a.compareTo(b));
        HashSet<Long> set = new HashSet<>();
        int[] prime = new int[]{2,3,5};
        long currUgly = 1l;
        pq.add(currUgly);
        while(n>0)
        {
            currUgly = pq.poll();
            n--;
            for(int pr:prime)
            {
                long newUgly = currUgly * pr;
                if(!set.contains(newUgly))
                {
                    pq.add(newUgly);
                    set.add(newUgly);
                }
            }
        }
        return (int)currUgly;
    }
}
