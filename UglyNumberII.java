package dp6;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberII {
	//Time Complexity : O(n)
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int nthUglyNumber(int n) {
        if(n == 1)
            return 1;
        
        int[] res = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        res[0] = 1;
        
        for(int i = 1; i<n; i++) {
            int min = Math.min(n2, Math.min(n3, n5));
            res[i] = min;
            if(n2 == min) {
                p2++;
                n2 = 2 * res[p2];
            }
            if(n3 == min) {
                p3++;
                n3 = 3 * res[p3];
            }
            if(n5 == min) {
                p5++;
                n5 = 5 * res[p5];
            }
        }
        
        return res[n - 1];
    }
	
	//Time Complexity : O(n log n)
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int nthUglyNumber1(int n) {
        if(n == 1)
            return 1;
        
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        minHeap.add(1l);
        set.add(1l);
        int[] primes = {2, 3, 5};
        
        for(int i=1; i<n; i++) {
            long num = minHeap.poll();
            for(int prime: primes) {
                long curr = num * prime;
                if(!set.contains(curr)) {
                    set.add(curr);
                    minHeap.add(curr);
                }
            }
        }
        
        long res = minHeap.poll();
        return (int)res;
    }
}
