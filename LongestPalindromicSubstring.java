// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int max, start, end;
    
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        
        for(int i = 0; i < n; i++) {
            expandAroundCorner(s, i, i);
            
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                expandAroundCorner(s, i, i + 1);
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    
    private void expandAroundCorner(String s, int left, int right) {
        
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        left++;
        right--;
        
        if(max < right - left + 1){
            max = right - left + 1;
            start = left;
            end = right;
        }
    }
}