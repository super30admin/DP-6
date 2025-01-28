// Time Complexity :O(n) as all the numbers are traversed once
//Space Complexity : O(n) for storing array
public class UglyNumber {
    public int nThUglyNumber(int n){
        // Array to store ugly numbers
        int [] ugly = new int [n];
        ugly [0] = 1; // first ugly number is equal to 1

        // pointers ot numbers 2,3 and 5
        int p2 = 0, p3 =0, p5 = 0;

        // factors  initialize the next multiples of 2,3, and 5
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;

        for ( int i =1; i < n; i++){
            // choose the smallst next multiple

            int nextUgly =  Math.min( nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            ugly[i] = nextUgly;

            // increment the pointer for the factor that matches the smallest multiple

            if( nextUgly == nextMultipleOf2){
                p2++;
                nextMultipleOf2 = ugly[p2] * 2;
            }
            if( nextUgly == nextMultipleOf3){
                p3++;
                nextMultipleOf3 = ugly[p3] * 3;
            }

            if( nextUgly == nextMultipleOf5){
                p5++;
                nextMultipleOf5 = ugly[p5] * 5;
            }
        }

        return ugly[n - 1];
    }

    public static void main ( String [] args){
        UglyNumber solution = new UglyNumber();

        int n1 = 10;
        System.out.print(solution.nThUglyNumber(n1));

    }
}
