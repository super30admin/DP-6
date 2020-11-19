// TC: O(n)
// SC: O(1)

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        // if (n < 1) {
        //     return 0;
        // }
        // else if(n >= 1 && n <= 1690){
        //     int temp = 1;
        //     int j = 0;
        //     int x = temp;
        //     int t = 1;
        //     int[] divisors = {2, 3, 5};
        //     while(j <= n){
        //         t = temp;
        //         for (int d : divisors) {
        //             while (temp % d == 0) {
        //                 temp = temp / d;
        //             }
        //         }
        //         if(temp == 1){
        //             j++;
        //         }
        //         temp = x++;
        //     }
        //     return t;
        // }
        // return 0;
        
        int[][] arr = new int[3][n+1];
        int a = 0;
        int b = 0;
        int c = 0, result = 1;
        // iterating n-1 just because we have 1 as the first ugly number
        for(int i=0; i<n-1; i++){
            // list of ugly numbers with prime factors that include 2
            arr[0][i] = result * 2;
            // include 3
            arr[1][i] = result * 3;
            // include 5
            arr[2][i] = result * 5;
            // taking smaller ungly of all 3
            result = Math.min(Math.min(arr[0][a], arr[1][b]), arr[2][c]);
            // comparing the value of the result with the list
            if(arr[0][a] == result)
                a++;
            if(arr[1][b] == result)
                b++;
            if(arr[2][c] == result)
                c++;
            
        }
        return result;
    }
}