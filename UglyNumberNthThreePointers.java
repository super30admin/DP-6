import java.util.Scanner;

public class UglyNumberNthThreePointers {

        // Three Pointers - Time O(n) and Space O(n)

        public int nthUglyNumber(int n) {

            // three pointers at zeroth index initially
            int p2 = 0;
            int p3 = 0;
            int p5 = 0;

            // ugly array with first element as 1 and consisting of ugly numbers in order
            int[] uglyArr = new int[n];
            uglyArr[0] = 1;

            // initial ugly numbers
            int n2 = uglyArr[p2] * 2;
            int n3 = uglyArr[p3] * 3;
            int n5 = uglyArr[p5] * 5;

            int min;

            // iterate over indices of ugly array
            for(int i = 1; i < n; i++) {

                // take minimum of ugly numbers
                min = Math.min(n2, Math.min(n3, n5));

                // push minimum ugly number into array
                uglyArr[i] = min;

                // move appropriate pointer ahead based on which number is minimum and added to array
                // update number at updated pointer
                // this movement of pointers keeps the ascending of ugly numbers array
                if(min == n2) {

                    p2++;
                    n2 = uglyArr[p2] * 2;
                }

                if(min == n3) {

                    p3++;
                    n3 = uglyArr[p3] * 3;
                }

                if(min == n5) {

                    p5++;
                    n5 = uglyArr[p5] * 5;
                }
            }

            // output nth ugly number
            return uglyArr[n-1];
        }

        public static void main(String[] args) {

            UglyNumberNthThreePointers obj = new UglyNumberNthThreePointers();

            Scanner scanner = new Scanner(System.in);

            System.out.println("n: ");
            int n = scanner.nextInt();

            int answer = obj.nthUglyNumber(n);

            System.out.println("nth ugly number is " + answer);
        }

}

/*
Time Complexity = O(n)
Space Complexity = O(n)
*/