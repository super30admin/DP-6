//APPROACH 2
//TC:O(n^2)
//SC:O(n)
//running on leetcode: yes
class Solution {
    int max, start, end;
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0) return "";
        int n = s.length();
        for(int i=0; i<n; i++) {
            expandAroundCenters(s, i, i);
            if(i+1 < n && s.charAt(i+1) == s.charAt(i+1)) {
                expandAroundCenters(s, i, i+1);
            }
        }
        return s.substring(start, end+1);
    }
    private void expandAroundCenters(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) ==s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;
        if(right - left +1 > max) {
            max=right-left+1;
            start=left;
            end=right;
        }
    }
}
