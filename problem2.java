// Time Complexity : O(slog P)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Approach
we are using the expanded from the each itteration
at each place we there can we an EVEN len or ODD len
for EVEN len char at i+1 and i will be same
so we take calculate both every time
*/
class Solution {
    public String longestPalindrome(String s) {
        int[] result = new int[2];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // odd
            expandFromCenter(s, i, i, result);

            // even
            if (i != n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                expandFromCenter(s, i, i + 1, result);
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    private void expandFromCenter(String s, int l, int r, int[] result) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        r--;
        if (result[1] - result[0] < r - l) {
            result[1] = r;
            result[0] = l;
        }
    }
}