/*
Time Complexity: O(N^2), N is the length of String s
Space Complexity: O(1), constant space
Any difficulty: No
Run on Leetcode: yes

Approach:
1. Expanding over the center and then calculating indices of start and end of the palindromic substring
 */
public class LongestPalindromicSubString {
    public static int minStart = 0;
    public static int minEnd = 0;

    public static String longestPalindromicSubstring(String s){

        for(int i= 0; i<s.length(); i++){
            palindromeCheck(s, i, i); // Odd length Strings
            palindromeCheck(s, i, i+1); // Even length Strings
        }

        return s.substring(minStart, minEnd+1);
    }

    // Checking if the string is expanding palindromically or not
    public static void palindromeCheck(String s, int left, int right){

        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            if((right-left-1)>(minEnd-minStart-1)){
                minStart = left;
                minEnd = right;
            }
            left--;
            right++;
        }
    }

    public static void main(String[] args){
        System.out.println("Longest Palindromic Substring: "+ longestPalindromicSubstring("babad"));
    }
}
