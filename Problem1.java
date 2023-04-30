import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
/*
Ugly Number ii
approach: we can see we have to sort in case of priority queue, we can reduce it as there are only  numbers we have to form each time.
time: O(n log k) O(n)
space: O(1)
 */
public class Problem1 {
    public int nthUglyNumber(int n) {
        if (n==1) return 1;
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        long curr = 1L;
        priorityQueue.add(curr);
        set.add(curr);
        int[] primes = {2,3,5};
        while (n-->0) {
            curr = priorityQueue.poll();
            for (int i=0;i<3;i++) {
                Long nele = curr*primes[i];
                if (!set.contains(nele)) {
                    set.add(nele);
                    priorityQueue.add(nele);
                }
            }
        }
        return (int)curr;
    }

    public int nthUglyNumberOptimized(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1;i<n;i++) {
            int min = Math.min(n2, Math.min(n3, n5));
            res[i] = min;
            if (min==n2) {
                p2++;
                n2 = res[p2]*2;
            }
            if (min==n3) {
                p3++;
                n3 = res[p3]*3;
            }
            if (min==n5) {
                p5++;
                n5 = res[p5]*5;
            }
        }
        return res[n-1];
    }

    public static void main(String []args) {
        Problem1 problem1 = new Problem1();
        problem1.nthUglyNumberOptimized(7);
    }
}
