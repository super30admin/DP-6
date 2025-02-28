class LongestPalindromicSubstring {
    int start; int maxLen;

    public String longestPalindrome(String s) {

        int n = s.length();
        for(int i = 0; i < n; i++){
            extendAroundCenter(s, i, i);//odd length
            extendAroundCenter(s, i, i + 1);//even length
        }
        return s.substring(start, start + maxLen);
    }

    private void extendAroundCenter(String s, int left, int right){

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; right++;
        }

        if(right - (left + 1) > maxLen){
            maxLen = right - (left + 1);
            start = left + 1;
        }
    }
}
