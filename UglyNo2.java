class Solution {
    //TC = 0(nlogk) where logk is for priority queue processing
    //SC = 0(m) m is max elements in hashset
    public int nthUglyNumber(int n) {
        if(n == 0 ){
            return 0;
        }
        HashSet<Long> set = new HashSet<>();    //I use a hashset to check if i have seen a no before or not and not to add or compute a no. twice
        PriorityQueue<Long> pq = new PriorityQueue<>(); //to keep the prime factors in ascending order
        pq.add((long)1);    //adding the 1st ugly no.
        set.add((long)1);   //also adding it to the set
        int [] primes = {2,3,5};
        long curr = 0;  //this gives out the nth ugly no.
        long count = 0; //this keeps a count of the no. of ugly no.'s processed
        while(count < n){   //the loop goes till I reach n
            curr = pq.poll();   //current keeps a track of the ugly no's process and the multiplication with prime factors are added to the queue for further processing
            for(int i = 0; i < primes.length; i++){ //runningg a loop to multiply with all prime factors
                long newno = curr * primes[i];
                if(!set.contains(newno)){   //if it contains, then I won't process it as I already have
                    set.add(newno);
                    pq.add(newno);
                }
            }
            count++;    //increasing count as 1 ugly no. has been processed
        }
        return (int)curr;
    }
}

//Optiized way
class Solution {

    //TC = 0(n)
    //SC = 0(n)

    public int nthUglyNumber(int n) {
        if(n == 0){
            return 0;
        }
        int p2 = 0, p3 = 0, p5 = 0; //p2, p3, and p5 are 3 pointers poiniting in result array
        int n2 = 2, n3 = 3, n5 = 5; //n2, n3, n5 hold the initial values of prime factors
        int [] result = new int [n];    //to add the no's in resultant array
        result[0] = 1;  //adding 1 as 1st prime factor
        for(int i = 1; i < n; i++){ //starts from 1 and goes upto n
            int min = Math.min(n2, Math.min(n3, n5));   //searching the min in 3 no's as that one will be the next no. to be added to resultatnt array. This also prevents duplicates and also keeps the resultant array in ascending order
            result[i] = min;
            if(min == n2){  //if my min is coming from n2
                p2++;   //I increase my p2 pointer
                n2 = result[p2] * 2;    //also set new value of n2 as 2 multiplied by the no that p2 is pointing to in my resultant array
            }
            if(min == n3){
                p3++;
                n3 = result[p3] * 3;
            }
            if(min == n5){
                p5++;
                n5 = result[p5] * 5;
            }
        }
        return result[n-1]; //returning the last index
    }
}