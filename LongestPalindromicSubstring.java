// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class LongestPalindromicSubstring {
    class Solution {
        private int start;
        private int end;
        public String longestPalindrome(String s) {
            start = 0;
            end = 0;

            for(int i=0; i<s.length(); i++) {
                //odd palindrom
                extendAroundCenter(s, i, i);

                //even palindrome
                if(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                    extendAroundCenter(s, i, i+1);
                }
            }
            return s.substring(start, end+1);
        }

        private void extendAroundCenter(String s, int low, int high) {
            while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            low++;
            high--;
            if(high - low > end - start) {
                start = low;
                end = high;
            }
        }
    }
}
