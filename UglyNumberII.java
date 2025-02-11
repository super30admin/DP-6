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