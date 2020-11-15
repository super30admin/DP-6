//TC: O(n log m), m >> n
//SC: O(m)
class Solution {
    public int nthUglyNumber(int n) {
        HashSet<Long> seen = new HashSet();
        int[] primes = new int[] {2,3,5};
        PriorityQueue<Long> pq = new PriorityQueue();
        pq.add(1l);
        int i = 1;
        long ugly = 1;
        while(i <= n){
            ugly = pq.poll();
            for(int prime : primes){
                long product = ugly*prime;
                if(!seen.contains(product)) {
                    pq.add(product);
                    seen.add(product);
                }
            }
            i++;
        }
        return Math.toIntExact(ugly);
    }
}

//TC: O(n)
//SC: O(n)
class Solution {
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        
        int[] arr = new int[n];
        arr[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Math.min(n2, Math.min(n3, n5));
            arr[i] = min;
            if(n2 == min){
                p2++; n2 = arr[p2] * 2;
            }
            if(n3 == min){
                p3++; n3 = arr[p3] * 3;
            }
            if(n5 == min){
                p5++; n5 = arr[p5] * 5;
            }
        }
        return arr[n-1];
    }
}
