//DP-6
 // Problem1: (https://leetcode.com/problems/ugly-number-ii/)
// Time Complexity - O(nlogn)
//Space - O(n)
class Solution {
    public int nthUglyNumber(int n) {
        //base case
        if(n == 1) return 1;
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> minHeap = new PriorityQueue();
        
        int[] primes = {2, 3, 5};
        
        int i = 1;
        long current = 1;
        
        set.add(current);
        minHeap.add(current);
        
        while(i <= n){
            current = minHeap.poll();
            for(int p: primes){
                long next = current * p;
                
                if(!set.contains(next)){
                    set.add(next);
                    minHeap.add(next);
                }
                
            }
            i++;
        }
        
        return (int) current;
    }
}

// DP
// Time Complexity - O(1) -- 1690
//Space - O(1) -- 1690
class Solution {
    public int nthUglyNumber(int n) {
        //base case
        if (n == 1) return 1;
        long[] result = new long[n];
        result[0] = 1;
        int count = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        while(count < n){
            result[count] = Math.min(Math.min(result[i2] * 2,result[i3] * 3 ), result[i5] * 5);
            if(result[count] == result[i2] * 2){
                i2++;
            }
            
            if(result[count] == result[i3] * 3){
                i3++;
            }
            
            if(result[count] == result[i5] * 5){
                i5++;
            }
            count++;
        }
        
        return Math.toIntExact(result[n - 1]);
    }
}