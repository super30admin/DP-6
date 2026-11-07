/**
 * Time Complexity:  O(n)  where n is the count of ugly numbers
 * Space Complexity: O(n)
 * Using DP
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];

        int p2=0, p3=0, p5=0;
        int n2=2, n3=3, n5=5;
        arr[0] = 1;
        for(int i=1; i<n; i++){
            int min = Math.min(n2, Math.min(n3, n5));
            arr[i] = min;

            if(n2 == min){
                p2++;
                n2 = arr[p2] * 2;
            }
            if(n3 == min){
                p3++;
                n3 = arr[p3] * 3;
            }
            if(n5 == min){
                p5++;
                n5 = arr[p5] * 5;
            }
        }
        return arr[n-1];
    }
}

/**
 * Time Complexity:  O(n log m) - where m is the total number of generated unique ugly numbers (> n)
 * Space Complexity: O(m)
 * Using Heap
 */
class Solution {
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        Queue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        set.add(1L);

        int[] primes = new int[]{2,3,5};
        long num = 0L;
        int count = 0;
        while(count != n){
            num = pq.poll();
            count++;
            for(int prime : primes){
                long newNum = prime * num;
                if(!set.contains(newNum)){
                    pq.offer(newNum);
                    set.add(newNum);
                }
            }
        }
        return (int)num;
    }
}