/*
Time Complexity: O(N), N is the given n
Space Complexity: O(N), size of ugly array
Run on leetcode: Yes
Any difficulties: no

Approach:
1. Creating number multiplying with the given prime numbers and checking the pointers created and
moving accordingly
 */
public class UglyNumberII {
    public static int nUglyNumberII(int n){
        int[] ugly = new int[n];
        ugly[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for(int i = 1; i<n; i++){
            int min = Math.min(ugly[p2]*2, Math.min(ugly[p3]*3, ugly[p5]*5));

            ugly[i] = min;

            if(min == ugly[p2]*2){
                p2++;
            }
            if(min == ugly[p3]*3){
                p3++;
            }
            if(min == ugly[p5]*5){
                p5++;
            }
        }
        return ugly[n-1];
    }
    public static void main(String[] args){
        System.out.println("UglyNumber II count: "+ nUglyNumberII(10));
    }
}
