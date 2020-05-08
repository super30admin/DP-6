// Time Complexity - O(nlog n) 
// Space Complexity - O(n)

//Approach 2
// Time Complexity - O(n) 
// Space Complexity - O(n)

class Solution {
    public int nthUglyNumber(int n) {
        
        //Two Approach
        // Multiply by 2,3,5 and add to minHeap and Set to keep track of unique product and in ascending order.
        //Procee until reaching
        
        // Approach 1
        
       /** PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<>();
        int i= 0;
        long curr = 1;
        minHeap.add((long)1);
        int[] prime = {2, 3, 5};
        while(i < n){
            curr = minHeap.poll();
           for(int j = 0; j<prime.length; j++){
             long product = curr * prime[j];
                if(!set.contains(product))
                    minHeap.add(product);
                    set.add(product);
                }
            i++;
            }
        return Math.toIntExact(curr); 
        **/
        
    
        // Approach 2
        long[] result = new long[1690];
        result[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
    
        for(int i = 1; i<n; i++){
            result[i] = Math.min(
                        Math.min(result[i2] * 2, result[i3] * 3), 
                        result[i5] * 5);
            
            if(result[i] == result[i2] *2){
                i2++;
            }
             if(result[i] == result[i3] *3){
                i3++;
            }
             if(result[i] == result[i5] *5){
                i5++;
            }
            
        }
     return Math.toIntExact(result[n-1]);   
    }
}
