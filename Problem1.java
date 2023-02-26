/*
The question states that we need to find the nth ugly number, and told us that an ugly number is a positive integer whose prime factores are 2,3,5

intuition:

We are given prime factors 2,3,5. Starting with 1, we can use the given prime factors to generate the next prime factor

We need to store the next prime factor in sorted fashion, which means the minimum element first

We will start by creating an array of n size,

we will store the number 1 into the first position
We will use 3 pointers each representing the factor starting with zero,
for the next element, we will take values from the indices the pointers are pointing at, then multiply the values with the corresponding factor number
and then take the minium value and place next

whichever the pointer or Pointers giving the min numbers, we will increment those by 1 . 
There could be multiple pointers giving the min value, so we will increment multiple, as the minimum value is already placed 

At the end , we will return the element at the last index

T:O(n)
S:O(N)
*/

class Solution {
    public int nthUglyNumber(int n) {

        int[] result = new int[n];
        int ptr2=0,ptr3=0,ptr5=0; // ptr for each prime factor // ptr2= 2, ptr3=3 , ptr5 = 5
        result[0] = 1;

        for(int i=0;i<n-1;i++){
            int val2 = result[ptr2] *2;  
            int val3 = result[ptr3] *3;
            int val5 = result[ptr5] *5;

            int min = Math.min(Math.min(val2,val3),val5);
            // whichever pointer gave minimum value, increment by 1
            // If multiple pointers gave minimum, then increment multiple
            if(min == val2){
                ptr2++;
            }
            if(min == val3){
                ptr3++;
            }
            if(min == val5){
                ptr5++;
            }
            result[i+1] = min; // the min is our next number
        }

        return result[n-1];
        
    }
}