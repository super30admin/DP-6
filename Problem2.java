
// Time - O(n log n)
// Space - O(n)


// Priority Queue Solution


class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();

        HashSet<Long> set = new HashSet<>();

        long currUgly = Long.valueOf(1);

        pq.add(currUgly);
        int [] primes = new int[]{2,3,5};
        int count = 1;

        while(count <= n) {

            currUgly = pq.poll();
            count++;

            for(int prime: primes) {
                long newUgly = currUgly * prime;
                if(!set.contains(newUgly)) {
                    pq.add(newUgly);
                    set.add(newUgly);
                }
            }


        }

        return (int)currUgly;

    }
}


// Time - O(n)
// Space - O(n)

// Optimized approach

class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int [] result = new int[n];
        int p2 = 0; int p3 = 0; int p5 = 0;
        int n2 = 2; int n3 = 3; int n5 = 5;
        result[0] = 1;

        for(int i = 1; i < n; i++) {

            int min = Math.min(n2,Math.min(n3,n5)); // take the minimum betweeen n2, n3 & n5
            result[i] = min;
            if(n2 == min) { // if n2 is minimum
                p2++;
                n2 = result[p2] * 2;
            }
            if(n3 == min) { // if n3 is minimum
                p3++;
                n3 = result[p3] * 3;
            }
            if(n5 == min) { // if n5 is minimum
                p5++;
                n5 = result[p5] * 5;
            }

        }

        return result[n-1];
    }
}