//Time Complexity: O(nlog(n))
//using Heap
class Solution {
    public int nthUglyNumber(int n) {
        //edge case
        if(n == 1)
            return 1;
        //Considering PriorityQueue to maintain the order &
        //HashSet to avoid duplicate factors
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        int i = 1;
        long ugly = 1;
        //add 1 to the queue and set initially
        pq.add(ugly);
        set.add(ugly);
        int [] primes = new int[] {2,3,5};
        while(i <= n){
            //poll first element from the queue to process
            //also remove it from the set
            ugly = pq.poll();
            set.remove(ugly);
            //multiply with all prime numbers
            //and add them to queue and set(if not already added)
            for(int prime : primes){
                long temp = prime * ugly;
                if(!set.contains(temp)){
                    set.add(temp);
                    pq.add(temp);
                }
            }
            //keep incrementing i
            i++;
        }
        //return the nth ugly number
        //converting long into int
        return Math.toIntExact(ugly);
    }
}

/********************************************************************************* */

//3-pointers (Optimal)
//Time Complexity: O(n)
class Solution {
    public int nthUglyNumber(int n) {
        //edge case
        if(n == 1)
            return 1;
        int p2 = 0; int p3 = 0; int p5 = 0;
        int n2 = 2; int n3 = 3; int n5 = 5;
        int [] arr = new int[n];
        arr[0] = 1;
        for(int i = 1;i < n; i++){
            //taking minimum of the 3 numbers(n2,n3,n5)
            arr[i] = Math.min(n2, Math.min(n3,n5));
            //if n2 is min; increment pointer2
            //multiply pointer index to 2
            if(arr[i] == n2){
                p2++;
                n2 = 2 * arr[p2];
            }
            //if n3 is min; increment pointer3
            //multiply pointer index to 3
            if(arr[i] == n3){
                p3++;
                n3 = 3 * arr[p3];
            }
            //if n5 is min; increment pointer5
            //multiply pointer index to 5
            if(arr[i] == n5){
                p5++;
                n5 = 5 * arr[p5];
            }
        }
        return arr[n-1];
    }
}