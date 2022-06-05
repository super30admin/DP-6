//Time Complexity : O(n^2); where n is length of input string.
//Space Complexity : O(1)
public class LongestPalindromicSubstring {		
	/**Approach: Two Pointers**/
	int start;
    int end;
    int maxLength;
    public String longestPalindrome(String s) {
        int n= s.length();
        maxLength = Integer.MIN_VALUE;
        start=0;
        end=0;        
        for(int i=0; i<n; i++){
        	if(end - start + 1 == n) return s; //optimization
            extendAroundChar(s, i, i); //odd length
            if(i<n-1 && s.charAt(i) == s.charAt(i+1)){
                extendAroundChar(s, i, i+1); //even length
            }
        }        
        return s.substring(start, end+1);
    }    
    private void extendAroundChar(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;            
        }
        int aLeft = left + 1;
        int aRight = right - 1;        
        if(aRight - aLeft + 1 > maxLength){
            maxLength = aRight - aLeft + 1;
            start = aLeft;
            end = aRight;
        }
    }
    
	// Driver code to test above
	public static void main (String[] args) {	
		LongestPalindromicSubstring ob  = new LongestPalindromicSubstring();	
		String s = "babad";
		System.out.println("Longest palindromic substring is: "+ ob.longestPalindrome(s));         
	}
}
