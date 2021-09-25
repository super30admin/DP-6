// Time Complexity : O(n), n -> Given number
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumbers2 {
	/********************* Priority Queue + HashSet *********************/
	// Time Complexity : O(nlog n), n -> Given number
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int nthUglyNumberPQueue(int n) {
		if (n == 1) {
			return 1;
		}

		PriorityQueue<Long> queue = new PriorityQueue<>();

		Set<Long> set = new HashSet<>();

		queue.add(1L);
		set.add(1L);
		long[] primes = { 2L, 3L, 5L };
		long curr = 0L;

		while (!queue.isEmpty() && n > 0) {
			curr = queue.poll();
			n--;

			for (long prime : primes) {
				long next = prime * curr;
				if (!set.contains(next)) {
					queue.add(next);
					set.add(next);
				}
			}
		}

		return (int) curr;
	}

	/********************* Optimized Dynamic Programming *********************/
	// Time Complexity : O(n), n -> Given number
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int nthUglyNumber(int n) {
		if (n == 1) {
			return 1;
		}

		int[] dp = new int[n];
		dp[0] = 1;
		int p2 = 0;
		int p3 = 0;
		int p5 = 0;

		for (int i = 1; i < n; i++) {
			int n2 = dp[p2] * 2;
			int n3 = dp[p3] * 3;
			int n5 = dp[p5] * 5;

			if (n2 <= n3 && n2 <= n5) {
				p2++;
				dp[i] = n2;
			}
			if (n3 <= n2 && n3 <= n5) {
				p3++;
				dp[i] = n3;
			}
			if (n5 <= n2 && n5 <= n3) {
				p5++;
				dp[i] = n5;
			}
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		UglyNumbers2 obj = new UglyNumbers2();

		int n = 7;

		System.out.println("Ugly number \'" + n + "\': " + obj.nthUglyNumber(n));
	}

}
