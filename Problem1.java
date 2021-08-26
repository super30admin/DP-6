
// time - O(n^2)
// space - O(n*n)

// DP solution
class Solution {
    public String longestPalindrome(String s) {
        if(s == null)  return "";
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        int start = 0; int end = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i-1][j+1])) { // if the characters are equal and in between character is less then 2 then true
                    dp[i][j] = true;
                    if(i - j + 1 > max) { // go over substrings and check the conditions
                        max = i - j + 1;
                        start = j; // reset start to j
                        end = i;
                    }
                }
            }
        }

        return s.substring(start,end+1);

    }
}


// time - O(n^2)
// space - O(1)

class Solution {

    int max;
    int start; int end;
    public String longestPalindrome(String s) {

        if(s == null) return "";

        int n = s.length();

        for(int i = 0; i< n; i++) {

            extendAroundCenter(s,i,i); // odd case

            if(i < n - 1 && s.charAt(i) == s.charAt(i+1)) { // even case
                extendAroundCenter(s,i,i+1);
            }


        }

        return s.substring(start,end + 1);
    }

    private void extendAroundCenter(String s, int left, int right) {

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++; // substring would start one right and left from end positions
        right--;
        if(right - left + 1 > max) {
            max = right - left + 1;
            start = left;
            end = right;
        }

    }

}