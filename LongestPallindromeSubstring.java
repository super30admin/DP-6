//Time complexity: O(n*n)
//Space Complexity:O(n*n)
class LongestPallindromeSubstring {
    public String longestPalindrome(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 1;
        dp[0][0] = true;
        int startIndex = 0;
        int endIndex = 0;

        for(int i =1; i< s.length(); i++){
            dp[i][i] = true;
            if(s.charAt(i) == s.charAt(i-1)){
                dp[i-1][i] = true;
                max = 2;
                startIndex = i-1;
                endIndex = i;
            }
        }

        for(int i = s.length()-3; i>=0; i--){
            for(int j=i+2; j< s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                    dp[i][j] = true;
                    if(max< (j-i+1)){
                        max = j-i+1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }

        return s.substring(startIndex, endIndex+1);




    }
}
