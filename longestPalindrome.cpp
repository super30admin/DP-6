// Time complexity: O(n^2)
// Space complexity: O(n^2)

class Solution {
public:
    string longestPalindrome(string s) {
        if(s.length() < 2)
            return s;
        int n = s.length();
        int max = -1, start, end;
        vector<vector<bool>> dp (n, vector<bool> (n, false));
        for(int i = 0; i<n; i++) {
            for(int j = 0; j <= i; j++) {
                // i - j - 1 is for aba or aa scenario
                if (s[i] == s[j] && (i-j-1 < 1 || dp[i-1][j+1])) {
                    dp[i][j] = true;
                    if(i-j+1 > max) {
                        max = i-j+1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substr(start, max);
    }
};


