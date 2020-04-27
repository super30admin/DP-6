package com.example.problems;

import java.util.*;
//	Time Complexity : O(1) for HEAP AND DP Approach

//Space Complexity : O(N) HEAP AND DP APPROACH
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*
 * Heap Solution
 * 	1.) Let's start from the heap which contains just one number: 1.
    2.) To compute next ugly numbers, pop 1 from the heap and push instead three numbers: 1×2, 1 1×3, and 1×5..
	3.) Now the smallest number in the heap is 2. To compute next ugly numbers, pop 2 from the heap and push instead three numbers: 2×2, 2×3, and 2×5
	4.) One could continue like this to compute first K ugly numbers. 
		At each step, pop the smallest ugly number k from the heap, and push instead three ugly numbers:
 * 
 * 
 * DP Solution
 * Precompute N ugly numbers:
   	1. )Initiate array of precomputed ugly numbers nums and three pointers i2, i3 and i5 to track the index of the last ugly
   	 	number used to produce the next ones.
	2.)Make a loop of N steps. At each step:
		a.)Choose the smallest number among nums[i2] * 2, nums[i3] * 3, and nums[i5] * 5 and add it into nums.
		b.)Move by one the pointer which corresponds to the "ancestor" of the added number.
	3. Retrieve needed ugly number from the array of precomputed numbers.
 * */
public class UglyNumber {

	static boolean shouldUseDP = true;

	public int nthUglyNumber(int n) {
		if (shouldUseDP) {
			return dpSol(n);
		}
		return heapSol(n);
	}

	public int dpSol(int n) {
		if (n == 1)
			return 1;
		int[] dp = new int[n];
		int n2 = 2, n3 = 3, n5 = 5;
		int p2 = 0, p3 = 0, p5 = 0;

		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.min(n2, Math.min(n3, n5));
			if (dp[i] == n2) {
				p2++;
				n2 = 2 * dp[p2];
			}
			if (dp[i] == n3) {
				p3++;
				n3 = 3 * dp[p3];
			}
			if (dp[i] == n5) {
				p5++;
				n5 = 5 * dp[p5];
			}
		}
		return dp[n - 1];
	}

	public int heapSol(int n) {
		if (n == 1)
			return 1;
		long curUgly = 0, newUgly = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		HashSet<Long> seen = new HashSet<>();
		pq.add(1L);
		seen.add(1L);
		int counter = 1;
		int primes[] = { 2, 3, 5 };
		while (counter < n) {
			curUgly = pq.poll();
			for (int prime : primes) {
				newUgly = prime * curUgly;
				if (!seen.contains(newUgly)) {
					pq.add(newUgly);
					seen.add(newUgly);
				}
			}
			counter++;
		}
		return Math.toIntExact(pq.poll());
	}

	public static void main(String args[]) {
		UglyNumber ugly = new UglyNumber();
		int n = 10;
		System.out.print(ugly.nthUglyNumber(n));
	}

}
