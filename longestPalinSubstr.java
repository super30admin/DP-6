class Solution {
    public String longestPalindrome(String s) {
        // Tc: O(n^2) Sc: O(1)
        if (s.length() <= 1)
            return s;
        String ans = "";

        for (int i = 1; i < s.length(); i++) {
            int start = i;
            int end = i;

            while (s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
                if (start == -1 || end == s.length())
                    break;
            }

            String palin = s.substring(start + 1, end);
            if (palin.length() > ans.length())
                ans = palin;

            start = i - 1;
            end = i;

            while (s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
                if (start == -1 || end == s.length())
                    break;
            }

            palin = s.substring(start + 1, end);
            if (palin.length() > ans.length())
                ans = palin;

        }

        return ans;

    }
}