
class Solution {
    public int nthUglyNumber(int n) {
        int[] tracker = new int[n];
        
        tracker[0] = 1;
        
        int p2 = 0; int p3 = 0; int p5 = 0;
        int n2 = 2; int n3 = 3; int n5 = 5;
        
        for(int i = 1; i < n; i++){
            //get min of n2, n3, n5 and assign it to tracker[i]
            int min = Math.min(n2, Math.min(n3, n5));
            
            tracker[i] = min;
            //check if min matches n2 or n3 or n5 and update its corressponding pointer and its value
            if(min == n2){
                p2++;
                n2 = 2 * tracker[p2];
            }
            if(min == n3){
                p3++;
                n3 = 3 * tracker[p3];
            }
            if(min == n5){
                p5++;
                n5 = 5 * tracker[p5];
            }
        }
        //return the nth value in array
        return tracker[n-1];
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)