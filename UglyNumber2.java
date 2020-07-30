// Time Complexity : 
/*                      Approach 1 : Using Priority Queue : O(nlogn) where n is the number given
                        Approach 2: Using 3 Pointers: O(n)
// Space Complexity :
/*                      Approach 1 : Using Priority Queue : O(n) Priority Queue
                        Approach 2: Using 3 Pointers: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 3 pointers is not intuitive.
/* Your code here along with comments explaining your approach: In approach 1, we use a priority queue to keep a track of the minimum number we get
after multiplication with 2,3,5. We start from 1 and then we do the multiplication with all the three numbers and put it into the set to avoid duplicates.
We add it to the priority queue to get the minimum number after multiplication that is explored next by the multiplication. In approach 2, we have 3
pointers that keep value of multiplication with respective 2,3,5. The minimum multiplied number pointer p'i is incremented once we get the min
and the number at p'i index is multiplied with the respective i-> 2,3,5. The process is repeated till i crosses n.
*/
// APPROACH 1 : USING PRIORITY QUEUE
class Solution {
    public int nthUglyNumber(int n) {
        if(n == 0) return 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();                                                 // Min heap
        int[] nos = new int[]{2,3,5};                                                               // 3 numbers
        HashSet<Long> set = new HashSet<>();
        long ugly = 1;
        pq.add(ugly);
        set.add(ugly);                                                                          // Add 1 to the set
        int i = 1;
        long r = 1;
        long number =1;
        while(i <= n){
            number = pq.poll();                                                                 // Poll the min number one by one
            for(int j : nos){
                r = number * j;                                                             // Get the result of all 3 multiplication
                if(!set.contains(r))                                                            // If set doesnt have
                    {    set.add(r);
                         pq.add(r);                                                         // Add it to the Priority queue to get next min number
                    }
            }
            i++;
        }
        return Math.toIntExact(number);                                                             // Convert Long to Int
    }
}

// APPROACH 2 : USING 3 POINTERS
class Solution {
    public int nthUglyNumber(int n) {
        if(n == 0) return 0;                                                                                // Base case
        int[] nos = new int[]{2,3,5};
        int p1 = 0, p2 = 0, p3 = 0, n1 = nos[0], n2= nos[1], n3= nos[2];                                // Initialising numbers and respective pointers
        int i = 1;
        int[] res = new int[n];
        res[0] = 1;
        while(i < n){
            n1 = res[p1] * nos[0];                                                                  // n1 is number at p1 index * 2
            n2 = res[p2] * nos[1];                                                                  // n2 is number at p2 index * 3
            n3 = res[p3] * nos[2];                                                                  // n3 is number at p3 index * 5
            int min = Math.min(n1, Math.min(n2,n3));
            res[i] = min;                                                                           // Result keeps the minimum among 3
            if(min == n1){                                                                          // Min satisfies whichever pointer, increment the pointer
                p1++; 
            } 
            if(min == n2){
                p2++; 
            } 
            if(min == n3){
                p3++; 
            }
            i++;
        }
        return res[i-1];                                                                            // Return the last element as result
    }
}