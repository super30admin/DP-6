//https://leetcode.com/problems/ugly-number-ii
//TC : O(N)
//SC : O(N)
//N - number of elements form by the factors . N > n ( input )

class Solution {
    public int nthUglyNumber(int n) {
        if(n==1)return 1;
        int [] factors = new int[]{2,3,5};
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.add(1L);
        set.add(1L);
        int count = 0;
        while(!pq.isEmpty()){
            long curr = pq.poll();
            count++;
            if(count == n) return (int)curr;
            for(int factor : factors){
                long newUgly = (Long) (curr * factor);
                if(!set.contains(newUgly)){
                    pq.add(newUgly);
                    set.add(newUgly);
                }
            }
        }
        return 13;
    }
}

//TC : O(n)
//SC : O(n)

class Solution {
    public int nthUglyNumber(int n) {
        if(n==1)return 1;
        int [] result = new int[n];
        result[0] = 1;
        int p2=0, p3=0, p5=0;
        int n2=2, n3=3, n5=5;
        for(int i=1;i<n;i++){
            int min = Math.min(n2,Math.min(n3,n5));
            result[i] = min;
            if(min == n2)
                n2 = result[++p2]*2;
            if(min == n3)
                n3 = result[++p3]*3;
            if(min == n5)
                n5 = result[++p5]*5; 
        }
        return result[n-1];
    }
}
