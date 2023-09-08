import java.util.Scanner;
import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumberNthMinHeapHashSet {

        // Min Heap Priority Queue and Hash set - Time O(Nlog(k)) and Space O(N)

        public int nthUglyNumber(int n) {

            // Priority Queue to maintain ascending order
            // Min Heap polls out the smallest number, keeping the ascending order
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            HashSet<Long> uniqueSet = new HashSet<>();

            minHeap.add(1L);
            uniqueSet.add(1L);

            // prime factors of ugly number
            int[] primes = new int[] {2,3,5};
            int count = 0;

            long uglyParent;
            long uglyChild;

            // loop to build ugly numbers in ascending order
            while(!minHeap.isEmpty()) {

                uglyParent = minHeap.poll();

                // increment count n
                count++;

                // output nth ugly number
                if(count == n) {

                    return (int)uglyParent;
                }

                // add next unique set of ugly numbers to min heap and hash set
                for(int factor: primes) {

                    uglyChild = factor * uglyParent;

                    if(!uniqueSet.contains(uglyChild)) {

                        minHeap.add(uglyChild);
                        uniqueSet.add(uglyChild);
                    }
                }
            }
            // unreached line
            return 9999;
        }

        public static void main(String[] args) {

            UglyNumberNthMinHeapHashSet obj = new UglyNumberNthMinHeapHashSet();

            Scanner scanner = new Scanner(System.in);

            System.out.println("n: ");
            int n = scanner.nextInt();

            int answer = obj.nthUglyNumber(n);

            System.out.println("nth ugly number is " + answer);
        }

}

/*
Time Complexity = O(Nlog(k))

N > n = more than n elements go inside priority queue and hash set
k = average number of elements inside priority queue
sorting takes log(k)

Space Complexity = O(N)
*/

