//TC: O(n^2)
//SC: O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j) && (i-j < 2 || dp[i-1][j+1])){
                    dp[i][j] = true;
                    if(i-j > end - start){
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}


//TC: O(n^2)
//SC: O(1)
class Solution {
    int start = 0, max = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i = 0; i < n; i++){
            extendPalindrome(s, i, i);
            if(i < n-1 && s.charAt(i) == s.charAt(i+1)){
                extendPalindrome(s, i, i+1);
            }
        }
        return s.substring(start, start+max);
    }
    
    private void extendPalindrome(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        if(r - l - 1 > max) //r - l + 1 changed to (r - 1) - (l + 1) + 1 -> r - l - 1
        {
            max = r - l - 1;
            start = l + 1;
        }
    }
}
