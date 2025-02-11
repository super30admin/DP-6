// Approach : With the definition of ugly number, number is ugly by multiplying it by 2,3 or 5.
// This helps to systematically generate ugly numbers rather than checking each number individually.
// Since we need to generate nth ugly number so we need to perform in order Hence opted for priorityQueue which will always have smallest unique number on top of the heap.
// Visited set to remove duplicate ugly numbers formed from other numbers.
// Time : O(nlogm)
// Space : O(m)
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> visitedSet = new HashSet<>();
        int[] prime = {2,3,5};
        long currUgly = 1;

        // add current ugly number to q
        pq.add(currUgly);
        visitedSet.add(currUgly);

        while(n>0){ // since we need to identify nth ugly number - perform n operations
            currUgly = pq.poll();
            for(int factor: prime){
                long newUgly = currUgly *factor;
                if(!visitedSet.contains(newUgly)){
                    pq.add(newUgly);
                    visitedSet.add(newUgly);
                }
            }
            n--;
        }

        return (int)currUgly;

    }
}

// Approach: Three Pointer Approach without using extra Datastructure.
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;

        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;

        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(n2, Math.min(n3, n5));

            if (arr[i] == n2) {
                p2++;
                n2 = arr[p2] * 2; // uglyNumber:2
            }
            if (arr[i] == n3) {
                p3++;
                n3 = arr[p3] * 3; // uglyNumber:3
            }
            if (arr[i] == n5) {
                p5++;
                n5 = arr[p5] * 5; // uglyNumber:5
            }
        }

        return arr[n - 1];
    }
}