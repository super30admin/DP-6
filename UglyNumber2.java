import java.util.HashSet;
import java.util.PriorityQueue;

// Approach 1

// TC : O(nlogk)
// SC : O(n)
class Solution1 {
    public int nthUglyNumber(int n) {
        if (n==1) return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        long curr = 1L;
        set.add(curr);
        pq.add(curr);
        int[] primes = new int[]{2,3,5};
        while(n!=0){
            curr = pq.poll();
            n--;
            for(int prime:primes){
                long newNum = curr * prime;
                if(!set.contains(newNum)){
                    pq.add(newNum);
                    set.add(newNum);
                }
            }
        }
        return (int)curr;
    }
}

// Optimized Approach

// TC - O(n)
// SC - O(n)
class Solution2 {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int p2=0,p3=0,p5=0;
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        int[] result = new int[n];
        result[0] = 1;
        for(int i=1;i<n;i++){
            int min = Math.min(n2,Math.min(n3,n5));
            result[i] = min;
            if (n2==min){
                p2++;
                n2 = 2 * result[p2];
            }
            if(n3 == min){
                p3++;
                n3 = 3 * result[p3];
            }
            if(n5 == min) {
                p5++;
                n5 = 5 * result[p5];
            }
        }
        return result[n-1];
    }
}