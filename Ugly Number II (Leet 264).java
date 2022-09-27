// Time: O(n)
// Space: O(n)

class Solution {
    public int nthUglyNumber(int n) {
        if (n==1) return 1;
        int [] arr = new int[n];
        arr[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        for (int i = 1; i < n; i++){
            int min = Math.min(n2, Math.min(n3,n5));
            arr[i] = min;
            if (min == n2){
                p2++;
                n2= arr[p2]*2;
            }
            if (min == n3){
                p3++;
                n3= arr[p3]*3;
            }
            if (min == n5){
                p5++;
                n5= arr[p5]*5;
            }
            
        }
        System.out.println(arr);
        return arr[n-1];
    }
}


//////

// Time: O(nlogk), where k can/cannot be greater than n
// Space: O(k)

class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1){
            return 1;
        }
        HashSet <Long> hs = new HashSet<>();
        PriorityQueue <Long> pq = new PriorityQueue<>();
        pq.add(1L);
        hs.add(1L);
        int count = 0;
        long [] primes = new long[] {2,3,5};
        
        while (count < n){
            long cUgly = pq.poll();
            hs.remove(cUgly);
            for (Long p: primes){
                if (!hs.contains(p*cUgly)){
                    hs.add(p*cUgly);
                    pq.add(p*cUgly);
                }
            }
            count++;
            if (count == n){
                return (int) cUgly;
            }
        }
        return 0; 
    }
}
