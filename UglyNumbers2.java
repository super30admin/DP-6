package DP6;

public class UglyNumbers2 {
	//TC : o(n)
	//SC : o(n)
	//Approach : Use priority queue for generating ugly numbers and use hashset for taking care of duplicacy. Stop when n is reached
	class Solution {
	    public int nthUglyNumber(int n) {
	        if(n==1) return 1;
	        PriorityQueue<Long> pq = new PriorityQueue<>();
	        HashSet<Long> set = new HashSet();
	        pq.add(Long.valueOf(1));
	        int count = 1;
	        long currUgly = 1;
	        int[] primes = new int[]{2,3,5};
	        while(count <= n){
	            count++;
	            currUgly = pq.poll();
	            for(int prime : primes){
	                long newUgly = prime * currUgly;
	                if(!set.contains(newUgly)){
	                    set.add(newUgly);
	                    pq.add(newUgly);
	                }
	            }
	        }
	        return (int)currUgly;
	    }
	}}
