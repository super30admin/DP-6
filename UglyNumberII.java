// Time Complexity : O(n) where k = number of elements is set
// Space Complexity : O(n) where k = number of elements is set
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//264. Ugly Number II (Medium) - https://leetcode.com/problems/ugly-number-ii/
// Time Complexity : O(n*logk) where k = number of elements is set
// Space Complexity : O(k) where k = number of elements is set
//class Solution {
//	public int nthUglyNumber(int n) {
//		if (n == 1)
//			return 1;
//
//		int p2 = 0, p3 = 0, p5 = 0;
//		PriorityQueue<Long> pq = new PriorityQueue<>();
//		HashSet<Long> set = new HashSet<>();
//		long curr = 1L;
//
//		set.add(curr);
//		pq.add(curr);
//
//		int[] primes = new int[] { 2, 3, 5 };
//
//		while (n != 0) {
//			curr = pq.poll();
//
//			for (int prime : primes) {
//				Long newNum = curr * prime;
//
//				if (!set.contains(newNum)) {
//					set.add(newNum);
//					pq.add(newNum);
//				}
//			}
//			n--;
//		}
//
//		return (int) curr;
//	}
//}

// Time Complexity : O(n) where k = number of elements is set
// Space Complexity : O(n) where k = number of elements is set
class Solution {
	public int nthUglyNumber(int n) {
		if (n == 1)
			return 1;

		int p2 = 0, p3 = 0, p5 = 0; // pointers
		int n2 = 2, n3 = 3, n5 = 5;

		int[] result = new int[n]; // O(n)
		result[0] = 1;

		for (int i = 1; i < n; i++) { // O(n)
			int min = Math.min(n2, Math.min(n3, n5));
			result[i] = min;

			if (n2 == min) {
				p2++;
				n2 = 2 * result[p2];
			}

			if (n3 == min) {
				p3++;
				n3 = 3 * result[p3];
			}

			if (n5 == min) {
				p5++;
				n5 = 5 * result[p5];
			}
		}

		return result[n - 1];
	}
}