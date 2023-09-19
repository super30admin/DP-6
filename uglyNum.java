// tc : O(n*log(n))
// sc : O(n)

// problem link : 

class Solution {
    public int nthUglyNumber(int n) {
        // declare
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int[] arr = { 2, 3, 5 };

        // intitialize
        set.add((long) 1);
        pq.add((long) 1);
        long curr = 1;
        int counter = 1;
        while (counter < n) {
            counter++;
            curr = pq.poll();
            for (int num : arr) {
                if (set.contains(num * curr))
                    continue;
                pq.add(num * curr);
                set.add(num * curr);
            }
        }
        curr = pq.poll();
        return (int) curr;
    }
}
