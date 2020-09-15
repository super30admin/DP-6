//time complexity: nlogn
//space complexity: O(1) constant 1690
//APPROACH: Using stack and priority queue

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        int i = 1;
        long ugly = 1;
        pq.add(ugly);
        set.add(ugly);
        int[] primes = new int[]{2,3,5};
        while(i <= n){
            ugly = pq.poll();
            for(int prime: primes){
                long num = ugly*prime;
                if(!set.contains(num)){
                    pq.add(num);
                    set.add(num);
                }
            }
            i++;
        }
        return Math.toIntExact(ugly);
    }
}

//APPROACH: 2 pointers
//time complexity: O(n)
//space complexity: O(n)

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int p2 = 0; int p3 = 0; int p5 = 0;
        int n2 = 2; int n3 = 3; int n5 = 5;
        int[] arr = new int[n];
        arr[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Math.min(n2, Math.min(n3, n5));
            arr[i] = min;
            if(min == n2){
                p2++; n2 = arr[p2]*2;
            }
            if(min == n3){
                p3++; n3 = arr[p3]*3;
            }
            if(min == n5){
                p5++; n5 = arr[p5]*5;
            }
        }
        return arr[n-1];
    }
}
