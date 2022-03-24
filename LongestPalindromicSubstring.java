// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class LongestPalindromicSubstring {

    int start;
    int end;

    public String longestPalindrome(String s) {
        //null case
        if(s == null || s.length() == 0) return s;

        for(int i = 0; i < s.length(); i++){
            //even length longestPalindrome
            extendAroundCenter(s, i, i);
            //odd length longestPalindrome
            extendAroundCenter(s, i, i+1);
        }
        return s.substring(start, end + 1);
    }

    private void extendAroundCenter(String s, int left, int right){

        while(left >= 0 && right < s.length() //bound check
                && s.charAt(left) == s.charAt(right)){

            left--;
            right++;
        }
        //longest palindrome till now
        int newPalindromeLength = right-left-1;
        if(newPalindromeLength > (end - start + 1)){
            //new start and end of longest palindrome
            start = left + 1;
            end = right - 1;
        }
    }
}
