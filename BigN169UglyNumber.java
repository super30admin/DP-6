import java.util.HashSet;
import java.util.PriorityQueue;

// Time complexity is O(nlogn) i.e its is less then logn because of priority queue
// Space complexity is O(N*logn)
// This solution is submitted on leetcode

public class BigN169UglyNumber {
	class Solution {
		public int nthUglyNumber(int n) {
			// edge case
			if (n == 0)
				return 0;
			PriorityQueue<Long> pq = new PriorityQueue<>();
			HashSet<Long> set = new HashSet<>();
			int i = 0;
			long ugly = 1L;
			pq.add(ugly);
			set.add(ugly);
			int[] primes = new int[] { 2, 3, 5 };
			while (i < n) {
				ugly = pq.poll();
				for (int prime : primes) {
					long temp = prime * ugly;
					if (!set.contains(temp)) {
						set.add(temp);
						pq.add(temp);
					}
				}
				i++;
			}
			return Math.toIntExact(ugly);
		}
	}
}