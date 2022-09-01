//TC : O(N * Log N)
//SC : O(N)

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        
        pq.add((long)1); set.add((long)1); // From 1 -> Generate 2,3,5 then 2 -> {} ,3 -> {}, 5-> {} like that 
        int res = 0;
        long l = 0;
        int[] facts = {2,3,5};
        while(res != n){
            l = pq.poll();
            res++;
            for(int i : facts){
                Long temp = i * l;
                if(!set.contains(temp))
                    pq.add(temp);
                    set.add(temp); 
                
            }
        }
        return (int)l;
    }
}

//TC : O(N)
//SC : O(1) // constant


class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        
        int i = 0, j = 0, k = 0; //Pointers for 2,3,5
        int v1 = 2, v2 = 3, v3 = 5; //For Values 2,3,5
        for(int x = 1; x < n; x++){
            int min = Math.min(v1, Math.min(v2,v3));
            res[x] = min;
            
            if(min == v1){
                i++;
                //if(i < n)
                v1 = res[i] * 2;
            }
            if(min == v2){
                j++;
                //if(j < n)
                v2 = res[j] * 3;                
            }
            if(min == v3){
                k++;
                //if(k < n)
                v3 = res[k] * 5;                
            }
        }
        
        
        return res[n-1];
    }
}


