
/* Problem Statement: 
Verified on LeetCode
5. Longest Palindromic Substring
Medium

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"



 * Best Solution : DYNAMIC PROGRAMMING, 
 * Time Complexity : O(n^2) where n is length of string
 * Space Complexity : O(n^2) for DP array 
 */

class Solution {
public:
    string longestPalindrome(string s) {
        int idx = 0, idx1 = 0;
        int len = s.size();
        string result;
        int curr_len = 0, new_len = 0;
        int start = 0;
        
        /* base case */
        if (len == 0) {
            return result;
        }
        
        bool dp[len][len];
        
        /* Initialize the array with false entries */
        for (idx = 0; idx < len; idx++) {
            for (idx1 = 0; idx1 < len; idx1++) {
                dp[idx][idx1] = false;
            }
        }
        /* Start from bottom left corner */
        for (idx = len - 1; idx >= 0; idx--) {
            for (idx1 = 0; idx1 < len; idx1++) {
                /* If char match, then do the following */
                if (s[idx] == s[idx1]) {
                    /* If the substr under consideration is less than equal to 2 or 
                    * we are the opposite corners of the dp matrix, then set to true*/
                    if (abs(idx - idx1) <= 2 || (idx + 1 >= len || idx1 - 1 < 0) )
                        dp[idx][idx1] = true;
                    else {
                        /* we have got a match, but the lenght is more than 2, so now check for the another substring within this substring by incrementing and decrementing the indexes of the string */
                        dp[idx][idx1] = dp[idx+1][idx1-1];
                    }
                    /* Well !! if the dp value is indeed true now, check for the substring length :) */
                    if (dp[idx][idx1] == true) {
                        new_len = idx1 - idx + 1;
                        if (new_len > curr_len) {
                            start = idx;
                            curr_len = new_len;
                        }
                    }
                }
            }
        }
        return s.substr(start, curr_len);
    }
};
