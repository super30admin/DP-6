package Q_5_Longest_Palindromic_Substring;

//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//Example 1:
//
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//Example 2:
//
//Input: "cbbd"
//Output: "bb"

//Time Complexity  : O(n^2)
//Space Complexity : O(n^2s)

public class Solution {

	public String longestPalindrome(String s) {
		//base
		if(s == null || s.length() == 0) {
			return null;
		}
		
		if(s.length() <2) {
			return s;
		}
		
		int l =  s.length();
		int start = 0 ,end =0;
		boolean[][] dp = new boolean[l][l];
		for(int i=0;i< s.length();i++) {
			for(int j=i; j>=0;j--) {
				if(s.charAt(i) == s.charAt(j) && ( (i-j <=2) || dp[i-1][j+1])) {
					dp[i][j] = true;
					if((i - j) > (end-start)) {
						end =i;
						start = j;
					}
					
				}
			}
		}
		
		return s.substring(start,end+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s= new Solution();
		String S = "aba";
		System.out.println(s.longestPalindrome(S));

	}

}
