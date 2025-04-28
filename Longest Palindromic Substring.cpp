// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
// Did the code run successfully? Yes

// Approach:
// 1. Create a 2D array to store the palindrome status of substrings
// 2. Initialize the first and last indices of the longest palindrome
// 3. Use two nested loops to check each substring
// 4. If the characters at the start and end of the substring are equal and the substring is a palindrome, update the array
// 5. If the length of the current palindrome is greater than the previous longest, update the start and end indices
// 6. Return the longest palindromic substring

class Solution {
    public:
        string longestPalindrome(string s) {
            int n = s.size();
            if(n < 2){return s;}
            vector<vector<bool>> dp(n, vector<bool>(n, false));
            int start = 0, end = 0;
            for(int i = 0; i < n; i++){
                for(int j = i; j >= 0; j--){
                    if(s[i] == s[j] && (i - j <= 2 || dp[i - 1][j + 1])){
                        dp[i][j] = true;
                        if(i - j > end - start){
                            start = j;
                            end = i;
                        }
                    }
                }
            }
            return s.substr(start, end - start + 1);
        }
    };