class Solution {

    // 3 pointers
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }

        int[] result = new int[n];
        result[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        for (int i = 1; i < n; ++i) {
            int next2 = result[p2] * 2;
            int next3 = result[p3] * 3;
            int next5 = result[p5] * 5;

            result[i] = Math.min(next2, Math.min(next3, next5));

            if (result[i] == next2) {
                p2++;
            }
            if (result[i] == next3) {
                p3++;
            }
            if (result[i] == next5) {
                p5++;
            }

        }
        return result[n -1];
    }


    // Using PQ + Set
    // m -  number of elements in heap
    // TC: n*log(n)and SC: O(m)

    public int nthUglyNumber1(int n) {
        if (n == 1) {
            return 1;
        }
        int count = 0;
        long x = 1;
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        set.add(1L);
        pq.add(1L);

        while(count < n) {
            x = pq.poll();
            count++;

            if(!set.contains(x * 2)) {
                set.add(x * 2);
                pq.add(x * 2);
            }
            if(!set.contains(x * 3)) {
                set.add(x * 3);
                pq.add(x * 3);
            }
            if(!set.contains(x * 5)) {
                set.add(x * 5);
                pq.add(x * 5);
            }

        }

        return (int) x;


    }

}