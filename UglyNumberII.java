// time: O(N) | Space: O(1)

// three pointers soln

class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int n2 = 2, n3 = 3, n5 = 5;
        for(int i=1;i<n;i++) {
            int min = Math.min(n2, Math.min(n3, n5));
            arr[i] = min;
            if(n2 == min) {
                p2++;
                n2 = 2*arr[p2];

            }
            if(n3 == min) {
                p3++;

                n3 = 3*arr[p3];
            }
            if(n5 == min) {
                p5++;

                n5 = 5*arr[p5];
            }
        }
        return arr[n-1];
    }
}

// time: O(NK) | Space: O(N*Log(K))
// heap soln
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        int[] primes = new int[]{2,3,5};
        long currUgly = 1;
        set.add(currUgly);
        pq.add(currUgly);

        for(int i=0;i<n;i++) {
            currUgly = pq.poll();
            if(i== n-1) break;
            for(int prime: primes) {
                long newUgly = prime* currUgly;
                if(!set.contains(newUgly)) {
                    set.add(newUgly);
                    pq.add(newUgly);
                }
            }
        }
        return (int)currUgly;
    }
}