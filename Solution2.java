// Time Complexity: O(n^2)
// Space Complexity: o(1)

class Solution2 {
    int start;
    int end;
    int max;
    public String longestPalindrome(String s) {
        int n = s.length();
        if( n == 1 ) {
            return s;
        }
        for(int i = 0; i < n; i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(start, end+1);
    }

    private void expand(String s, int left, int right) {
        while( left >= 0 && right < s.length() ) {
            if( s.charAt(left) == s.charAt(right) ) {
                left--;
                right++;
            } else {
                break;
            }
        }
        left++;
        right--;
        int temp = right - left + 1;
        if( max < temp ) {
            max = temp;
            start = left;
            end = right;
        }
    }
}