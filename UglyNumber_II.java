//Time Complexity : O(n); where n is input number.
//Space Complexity : O(n)
public class UglyNumber_II {    
	/**Approach: Array**/
	public int nthUglyNumber(int n) {
        int[] res = new int[n];        
        res[0] = 1;
        int i2=0; int i3=0; int i5=0;
        int n2=2; int n3=3; int n5=5;
       
        for(int i=1; i<n; i++){
            int min = Math.min(n2, Math.min(n3, n5));
            res[i] = min;
            if(min == n2){
                i2++;
                n2 = res[i2] * 2;
            }
            if(min == n3){
                i3++;
                n3 = res[i3] * 3;
            }
            if(min == n5){
                i5++;
                n5 = res[i5] * 5;
            }
        }
        return res[n-1];
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		UglyNumber_II ob  = new UglyNumber_II();	
		int n = 10;
		System.out.println(n + "th ugly number is: "+ ob.nthUglyNumber(n));         
	}
}
