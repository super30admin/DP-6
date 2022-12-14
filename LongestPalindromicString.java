// Time Complexity: O(n*n)
// Space Complexity: O(n * n)

class Solution {
    // int max, start, end, n;

    public String longestPalindrome(String s) {
//         if (s == null || s.length() == 0) return "";
//         n = s.length();

//         for (int i = 0; i < n; i++) {
//             expandAroundCenter(s, i, i); // checking for odd length
//             if (i + 1 < n) {
//                 expandAroundCenter(s, i, i +1); // checking for even length
//             }
//         }

//         return s.substring(start, end +1);
// DP based solution
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        int start = 0, end = 0;

        for (int i=0; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                if (s.charAt(i) == s.charAt(j)
                        && ((i - j - 1 <= 1) || dp[i-1][j+1])) {
                    dp[i][j] = true;
                    if (max < i - j + 1) {
                        max = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end+1);

    }

//     private void expandAroundCenter(String s, int left, int right) {
//         while (left >=0 && right <n && (s.charAt(left) == s.charAt(right))) {
//             left--;
//             right++;
//         }

//         left++;
//         right--;

//         if (max < right - left + 1) {
//             max = right - left + 1;
//             start = left;
//             end = right;
//         }
//     }
}