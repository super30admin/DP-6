package s30.dp.dp6;


//algo - DP -> start the dp matrix for substrings of length 1 and expand
//TC : O(n^2);
//SC: O(n^2);


//algo :-> assume every index as a possible mid of a palindrome and expand till palindrome is possible for odd and even strings.
//TC : O(n^2);
//SC: O(1);
public class LongestPalindromicSubstring {

    int maxLen, maxStart;
    public String longestPalindrome(String s) {
        maxLen =1;
        maxStart =0;

        int n = s.length();

        for(int i=0; i < n ; i++){

            explore(s, i-1, i+1); //odd
            explore(s, i, i+1 ); //even
        }


        return s.substring(maxStart, maxStart + maxLen);
    }


    private void explore(String s, int start, int end){
        int n = s.length();

        while(start >=0 && end < n && s.charAt(start) == s.charAt(end)){
            int len = end - start + 1;
            if(len > maxLen){
                maxLen = len;
                maxStart = start;
            }
            ++end;
            --start;
        }

    }

    //DP
    public String longestPalindromeDP(String s) {

        int maxLen =1, maxStart=0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int len =1; len <= n; len++){

            for(int start = 0, end = start + len -1; end < n; start++, end++){

                if(s.charAt(start) == s.charAt(end)){

                    if(len > 2)
                        dp[start][end] = dp[start+1][end-1];
                    else
                        dp[start][end] = true;
                }


                if(dp[start][end] && len > maxLen){
                    maxLen = len;
                    maxStart = start;
                }

            }
        }


        return s.substring(maxStart, maxStart + maxLen);

    }

    public static void main(String[] args) {

    }
}
