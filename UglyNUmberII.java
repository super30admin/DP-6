

/**
 * Generates the nth ugly number using a min-heap and a hash set to avoid duplicates.
 * Iteratively extracts the smallest ugly number and multiplies it by 2, 3, and 5.
 * Returns the nth ugly number after processing n elements from the heap.
 */
// Time Complexity: O(n log n), due to heap operations for n numbers
// Space Complexity: O(n), for storing heap and set of generated numbers
public class UglyNUmberII {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> a.compareTo(b));

        HashSet<Long> set = new HashSet<>();
        int[] prime = new int[]{2,3,5};

        long currUgly = 1l; 

        pq.add(currUgly);

        while(n > 0) {
            currUgly = pq.poll();
            n--;

            for(int pr : prime) {
                long newUgly = currUgly * pr; 
                if(!set.contains(newUgly)) {
                    pq.add(newUgly);
                    set.add(newUgly);
                }
            }
        }

        return (int) currUgly;
    }
}
