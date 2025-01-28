// Time Complexity:  O(n log k ) log n due to min heap and there will be k numbers left in the PQ and k is any number greater than n
// Space Complexity: O(n) for heap and set
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberUsingPrioirityQueue {
    public static int nThuglyNumberPQ ( int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();

        int[] prime = {2, 3, 5}; // ugly numbers are divisible by these prime factors
        long currUgly = 1;

        // add the first ugly number to min heap and marl it as visited in the set
        pq.add(currUgly);
        visited.add(currUgly);

        while (n > 0) {
            currUgly = pq.poll();
            for (int pr : prime) {
                long newUgly = currUgly * pr;
                if (!visited.contains(newUgly)) {
                    pq.add(newUgly);
                    visited.add(newUgly);
                }
            }
            n--;
        }
        return (int) currUgly;
    }

    public static void main( String[] args){
        UglyNumber solution = new UglyNumber();

        int n1 = 10;
        System.out.print(solution.nThUglyNumber(n1));
    }
}
