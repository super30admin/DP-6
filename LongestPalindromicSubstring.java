package DP6;
//TC : o(n)
//SC : o(n)
public class LongestPalindromicSubstring {
	class Solution {
	    public String longestPalindrome(String s) {
	        if(s == null || s.length() == 0) return "";
	        
	        int l = 0;
	        int r = 0;
	        for(int i=0; i<s.length(); i++){
	            int len1 = expandFromCenter(s,i,i);
	            int len2 = expandFromCenter(s,i,i+1);
	            int len = Math.max(len1, len2);
	            if(len > r-l){
	                l = i - (len-1)/2;
	                r = i + len/2;
	            }
	        }
	        return s.substring(l, r+1);
	    }
	    
	    private int expandFromCenter(String s, int l, int r){
	        while(l >=0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)){
	            l--;
	            r++;
	        }
	        return r-l-1;
	    }
	}
}
