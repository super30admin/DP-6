class Solution {

    //Approach 2, here new ugly numbers can be form from the old ugly numbers, that we are considering here, thats why we are storing the old numbers in result array and p2, p3 and p5 pointers points to the old ugly numbers and help us to get the new ugly numbers

    //Time Complexity: O(n)
    //Space Complexity: O(n)

    public int nthUglyNumber(int n) {

        if(n==1) return 1;                      //if n==1 then return 1

        int[] result = new int[n];              //create a result array to store the ugly number in sequence
        result[0] = 1;                          //add 1 to the result[0] as it's a first ugly number

        int index = 1;                          //create a index pointer which basically pointes where the next ugly number supposed to be stored in result array


        int p2 = 0;                             //p2,p3, p5 is pointers for 2,3,and 5 prime factor, and it points to the result array, currently all the pointers are pointing to 0th index
        int p3 = 0;
        int p5 = 0;

        int n2 = 2 * result[p2];                             //n2, n3, n5 shows the multiplication value of 2,3,and 5 factors with earlier ugly numbers
        int n3 = 3 * result[p3];
        int n5 = 5 * result[p5];


        while(index < n){                                   //iterate till index reaches to n

            int min = Math.min(n2, Math.min(n3, n5));       //get the min value from n2,n3,n5
            result[index] = min;                            //add the min value which is ugly number to the result
            index++;                                        //increment the index

            if(min == n2){                                  //check if n2 was the min number
                p2++;                                       //if yes, then increament the p2 pointer
                n2 = 2 * result[p2];                        //and get the new value of n2
            }

            if(min == n3){                                  //check if n3 was the min number
                p3++;                                       //if yes, then increament the p3 pointer
                n3 = 3 * result[p3];                        //and get the new value of n3
            }

            if(min == n5){                                  //check if n5 was the min number
                p5++;                                       //if yes, then increament the p5 pointer
                n5 = 5 * result[p5];                        //and get the new value of n5
            }
        }
        return result[n-1];                                 //return the n-1 index of result
    }




    //Approach 1
    //Time Complexity: O(k*log(k)) -> k is greater than n
    //Space Complexity: O(k)

    // public int nthUglyNumber(int n) {

    //     if(n==1) return 1;

    //     PriorityQueue<Long> queue = new PriorityQueue<>();
    //     Set<Long> set = new HashSet<>();

    //     long current = 1;

    //     queue.add(current);
    //     set.add(current);

    //     int count = 0;

    //     int[] primes = new int[]{2,3,5};

    //     while(count < n){

    //         current = queue.poll();
    //         count++;

    //         for(int i: primes){
    //             long newNum = current * i;

    //             if(!set.contains(newNum)){
    //                 queue.add(newNum);
    //                 set.add(newNum);
    //             }
    //         }
    //     }
    //     return (int)current;
    // }
}


public class UglyNumberIILC264 {
}
