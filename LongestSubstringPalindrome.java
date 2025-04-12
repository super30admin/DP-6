class LongestSubstringPalindrome {
    int maxLength;
    String result;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int l = 0;
        int r = 0;
        maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            isValidPalindrome(s, i, i);
            isValidPalindrome(s, i, i + 1);
        }
        return result;
    }

    private void isValidPalindrome(String s, int l, int r) {
        while (r < s.length() && l >= 0) {
            if (s.charAt(l) == s.charAt(r)) {
                r++;
                l--;
            } else {
                break;
            }
        }
        l++;
        r--;

        if (maxLength < r - l + 1) {
            maxLength = r - l + 1;
            result = s.substring(l, r + 1);
        }

    }

}
