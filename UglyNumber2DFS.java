// ## Problem1: (https://leetcode.com/problems/ugly-number-ii/)
// DFS using a priority queue
// Time: Exponential
// Space: O(N)
class Solution {
    public int nthUglyNumber(int n) {
        int count = 0;
        PriorityQueue<Long> q = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();     // keep track of visited
        q.add(1l);

        while(!q.isEmpty()){
            long curr = q.poll();
            count++;
            if(count == n){
                return (int)curr;
            }

            if(!set.contains(2*curr)){
                 q.add(2*curr);
                 set.add(2*curr);
            }
            if(!set.contains(3*curr)){
                 q.add(3*curr);
                 set.add(3*curr);
            }
            if(!set.contains(5*curr)){
                 q.add(5*curr);
                 set.add(5*curr);
            }
        }

        return 0;
    }
}