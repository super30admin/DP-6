package dp6;

public class LongestPalindromicSubstring {
	//Time Complexity : O(n^2), where n is the length of string s
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	int start = 0, end = 0;
    public String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;
        
        for(int i=0; i<s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }
        
        return s.substring(start, end + 1);
    }
    
    private void expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        if(right - left - 1 > end - start + 1) {
            start = left + 1;
            end = right - 1;
        }
    }
    
	//Time Complexity : O(n^2), where n is the length of string s
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	String res = "";
    public String longestPalindrome1(String s) {
        if(s.length() == 1)
            return s;
        
        for(int i=0; i<s.length(); i++) {
            expandAroundCenter1(s, i, i);
            expandAroundCenter1(s, i, i + 1);
        }
        
        return res;
    }
    
    private void expandAroundCenter1(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        if(right - left - 1 > res.length())
            res = s.substring(left + 1, right);
    }
    
	//Time Complexity : O(n^2), where n is the length of string s
	//Space Complexity : O(n^2)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public String longestPalindrome2(String s) {
        if(s.length() == 1)
            return s;
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j>=0; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(i - j < 2 || dp[i - 1][j + 1]) {
                        dp[i][j] = true;
                        if(res.length() <= i - j + 1)
                            res = s.substring(j, i + 1);
                    }
                }
            }
        }
        
        return res;
    }
	
	//Time Complexity : O(n^3), where n is the length of string s
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public String longestPalindrome3(String s) {
        if(s.length() == 1)
            return s;
        
        String res = "";
        for(int i=0; i<s.length() - 1; i++) {
            for(int j=i; j<s.length(); j++) {
                if(isPalindrome3(s, i, j) && res.length() < j - i + 1)
                    res = s.substring(i, j + 1);
                if(res.length() == s.length())
                    return res;
            }
        }
        
        return res;
    }
    
    private boolean isPalindrome3(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }
}
