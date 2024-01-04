// Time Complexity : O(slogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class longpalindromicSubstring {
    class Solution {
        int start;
        int end;
        public String longestPalindrome(String s) {
            int sLen = s.length();

        /*Expand from centre
        consider odd and even(caac) length pallindrom */

            for(int i = 0; i < sLen; i++){
                //odd length
                checkPallindrome(s, i, i);
                //even length
                checkPallindrome(s, i, i+1);
            }

            return s.substring(start, end+1);
        }

        private void checkPallindrome(String s, int l, int r){
            while(l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))){
                l--;
                r++;
            }
            l++;
            r--;

            if((end - start) < (r - l)){
                start = l;
                end = r;
            }
        }
    }
}
