//TC - O(1), as N is constant
//SC - O(1), as N is constant

import java.util.*;

class Solution {
	public int nthUglyNumber(int n) {
		if (n == 1)
			return 1;
		long ugly = 1;
		HashSet<Long> set = new HashSet<>();
		PriorityQueue<Long> pq = new PriorityQueue<>();
		set.add(ugly);
		pq.add(ugly);
		int i = 0;
		int prime[] = new int[] { 2, 3, 5 };
		while (i < n) {
			ugly = pq.poll();
			for (int primes : prime) {
				long calculated = primes * ugly;
				if (!set.contains(calculated)) {
					set.add(calculated);
					pq.add(calculated);
				}
			}
			i++;
		}
		return Math.toIntExact(ugly);
	}
}