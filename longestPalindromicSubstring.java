// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int st, ed;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";

        int n = s.length();

        for(int i=0;i<n;i++) {
            expandAroundCenter(s,i,i);
            if(i != n-1 && s.charAt(i) == s.charAt(i+1))
                expandAroundCenter(s,i,i+1);
        }
        return s.substring(st,ed+1);
    }

    private void expandAroundCenter(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        i++;
        j--;
        if(ed-st < j - i) {
            st = i;
            ed = j;
        }
    }
} 