class Solution {
    //method 1 : using min heap
    //TC :O(n log n)
//     public int nthUglyNumber(int n) {
        
//         // if(n < 1 || n > 1690){
//         //     return 0;
//         // }
//         long[]result = new long[n];
//         // result[0] = 1;
//         // result[1] = 2;
//         // result[2] = 3;
//         // result[3] = 5;
        
//         PriorityQueue<Long> pq = new PriorityQueue<>();
        
//         // pq.add(2);
//         // pq.add(3);
//         // pq.add(5);
        
//         int i = 0;
        
//         pq.add(1L);
//         pq.add(2L);
//         pq.add(3L);
//         while(!pq.isEmpty() && i < n){
//             long currNum = pq.poll();
//             result[i] = currNum;
//             i++;
            
//             if(!pq.contains(currNum * 2)){
//                 pq.add(currNum * 2);
//             }
//             if(!pq.contains(currNum * 3)){
//                 pq.add(currNum * 3);
//             }
//             if(!pq.contains(currNum * 5)){
//                 pq.add(currNum * 5);
//             }
            
            
//         }
        
//         long res = result[n-1];
//         return (int)res;
//     }
    
    
    
    //tC: O(n)
    //here we just make use of 3 pointers to solve.
    
     public int nthUglyNumber(int n){
         
         if(n == 1)return 1;
         
         int[]arr = new int[n];
         arr[0] =1;
         int p2 = 0;
         int p3 = 0;
         int p5 = 0;
         
         int num2 = 2;
         int num3 = 3;
         int num5 = 5;
         
         for(int i = 1; i < n;i++){
             int min = Math.min(num2, Math.min(num3, num5));
             arr[i] = min;
             
             if(num2 == min){
                 p2++;
                 num2 = arr[p2] * 2;
             }
             
             if(num3 == min){
                 p3++;
                 num3 = arr[p3] * 3;
             }
             
             if(num5 == min){
                 p5++;
                 num5 = arr[p5] * 5;
             }
         }
         return arr[n-1];
     }
}


/*
n =10
1 2 3 4 5 6 
*/