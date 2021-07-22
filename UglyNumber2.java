import java.util.*;

public class UglyNumber2 {


    //TC: O(NLogN) Using Priority Queue. Rearranging LogN and N times we are doing it.
    //SC: O(N):
    public int nthUglyNumber(int n) {
        // Every number should be multiplication of a prime number.
        // In order to form the ugly number, Find all combination by multiply with a
        // number.
        // And push it to the Priority queue(To maintain the order)

        if(n == 1) return 1;

        HashSet<Long> set = new HashSet();
        PriorityQueue<Long> pq = new PriorityQueue();
        int[] primeNumbers = new int[] { 2, 3, 5 };
        pq.add(1l);
        set.add(1l);

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                return Math.toIntExact(pq.poll());
            } else {
                long current = pq.poll();
                for (Integer prime : primeNumbers) {
                    long value = prime * current;
                    if (!set.contains(value)) {
                        set.add(value);
                        pq.add(value);
                    }
                }
            }
        }
        assert(false);
        return 0;
    }

    public static void main(String[] args) {
        UglyNumber2 uglyNumber2 = new UglyNumber2();
        int result = uglyNumber2.nthUglyNumber(10);
        System.out.println("The result: " + result);
    }
}