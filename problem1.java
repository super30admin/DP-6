import java.util.HashSet;
import java.util.PriorityQueue;

public class problem1 {

    //Using Heap
    //Time Complexity: nlog(N)
    //Space Complexity: O(n)

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        int[] prime={2,3,5};
        long currUgly=1;

        pq.add(currUgly);
        set.add(currUgly);

        while (n>0)
        {
            currUgly =pq.poll();
            for (int pr:prime)
            {
                long newUgly=currUgly*pr;
                if (!set.contains(newUgly))
                {
                    pq.add(newUgly);
                    set.add(newUgly);
                }
            }
            n--;
        }
        return (int)currUgly;

    }
}
