//Bruteforce
// In this bruteforce solution, starting with first ugly number that is 1, multiplying it by 2, 3, and 5, we 
// get another 3 ugly numbers. So, this way we can generate ugly numbers but the problem here is that this 
// numbers are also repeated and also they dont follow any order. So for this using two data structures; min 
// heap for the order and hashset for the duplicates. Initially taking a count variable with value as 0, then 
// as we start polling from the heap, if the number polled, if we multiply that by 2,3 and 5, and check if each
// of the output is in not in hashset than that is our next ugly number. So increment our count by 1, and put 
// this in set and in priority queue. Do this till count is less than n.

// Time Complexity : O(n)
// Space Complexity : O(n^3)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int nthUglyNumber(int n) {
        // Base case
        if (n == 1) {
            return 1;
        }
        // Declare count
        int count = 0;
        // Declare the two data structures, keep type as long because since we are
        // multiplying it can exceed the integer range
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        // Add the first ugly number we know i.e. 1 to both
        set.add((long) 1);
        pq.add((long) 1);
        // Take one curr, that will hold our ans at last
        long curr = 0;
        // Primes array
        int[] arr = { 2, 3, 5 };
        // Till our count is less than n
        while (count < n) {
            // Poll from the heap
            curr = pq.poll();
            // Do count++
            count++;
            // Now multipy this curr by 2,3 and 5 and generate more ugly numbers and if they
            // are not already in set, put in set and heap
            for (int a : arr) {
                if (!set.contains(curr * a)) {
                    set.add(curr * a);
                    pq.add(curr * a);
                }
            }
        }
        // At last return curr
        return (int) curr;
    }
}

// In this optimized approach, taking a result array, and storing at first
// index, the first ugly number. The result[n-1] will give the nth ugly number.
// So take few pointers p2 related to 2, p3 related to 3 and p5 related to 5.
// Then few other variables n2 number related to 2, n3 to 3, n5 to 5.
// Now start a loop from 1 to n, result[i] is the min of n2, n3 and n5. And
// whatever n variable gave this min value, increment the p pointer related to
// it. And update the n2 or n3 or n5 value to result[corresponding
// p]*corresponding num(2,3 or 5)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int nthUglyNumber(int n) {
        // Base case
        if (n == 1) {
            return 1;
        }
        // Declare result table of size n
        int[] result = new int[n];
        // Pointers and variables
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        // First ugly number is 1
        result[0] = 1;
        // Loop from 1 to n
        for (int i = 1; i < n; i++) {
            // Result will have the min of 3
            result[i] = Math.min(n2, Math.min(n3, n5));
            // Whatever gave that result
            if (result[i] == n2) {
                // Inc that related pointer
                p2++;
                // And update that variable value
                n2 = result[p2] * 2;
            }
            if (result[i] == n3) {
                p3++;
                n3 = result[p3] * 3;
            }
            if (result[i] == n5) {
                p5++;
                n5 = result[p5] * 5;
            }
        }
        // nth ugly number is given by result[n-1]
        return result[n - 1];
    }
}