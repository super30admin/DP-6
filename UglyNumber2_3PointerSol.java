package DP6;

public class UglyNumber2_3PointerSol {
	class Solution {
	    public int nthUglyNumber(int n) {
	        if(n == 1) return 1;
	        int[] res = new int[n];
	        res[0] = 1;
	        int p2 = 0;
	        int p3 = 0;
	        int p5 = 0;
	        int n2 = 2;
	        int n3 = 3;
	        int n5 = 5;
	        
	        for(int i=1; i<n; i++){
	            int min = Math.min(n2, Math.min(n3,n5));
	            res[i] = min;
	            if(n2 == min){
	                p2++;
	                n2 = res[p2]*2;
	            }
	            if(n3 == min){
	                p3++;
	                n3 = res[p3]*3;
	            }
	            if(n5 == min){
	                p5++;
	                n5 = res[p5]*5;
	            }
	        }
	        return res[n-1];
	    }
	}
}
