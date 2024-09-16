/*
The time complexity is O(n) where n is the nth ugly number and the space complexity is also O(n).

Here, the intuition is to create an ugly number one by one till we reach nth number.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int nthUglyNumber(int n) {

        int[] uarray = new int[n];

        //Base ugly number is 1.
        uarray[0] = 1;

        //We have three indexes for each number 2, 3, 5 which indicates the number at that index to be multiplied
        int id2 = 0; int id3 = 0; int id5 = 0;

        for(int i=1;i<n;i++){

            //Get the min of the three ugly numbers generated from 2, 3, 5
            int ugly = Math.min(uarray[id2]*2,Math.min(uarray[id3]*3,uarray[id5]*5));

            //Go to the next index
            if(ugly==uarray[id2]*2){id2++;}
            if(ugly==uarray[id3]*3){id3++;}
            if(ugly==uarray[id5]*5){id5++;}

            uarray[i] = ugly;
        }

        return uarray[n-1];
    }
}