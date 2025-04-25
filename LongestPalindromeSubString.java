
//TC-O(n^2) -SC O(1)
public class LongestPalindromeSubString {
    int start;
    int maxLen;
    public String longestPalindrome(String s) {
        int n=s.length();

        if(n<2) return s;

        for(int i=0;i<n;i++){
            extendPalindrome(s,i,i);
            extendPalindrome(s,i,i+1);
        }

        return s.substring(start, start + maxLen);

    }
    private void extendPalindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; right++;
        }
        if(right - (left + 1) > maxLen){
            maxLen = right - (left + 1);
            start = left + 1;
        }
    }

}
