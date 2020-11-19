// TC: O(n^2)
// SC: O(1)

public class LongestPallindromeSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // considering single character
            int len1 = expandAroundCenter(s, i, i);
            // considering 2 chars at a time
            int len2 = expandAroundCenter(s, i, i + 1);
            // considering the max value of the 2 which tells us that there a pallindromic string from the above chars
            int len = Math.max(len1, len2);
            // by len we get the start of the pallindrome and end of substring 
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        // returning the substring from start to end
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
