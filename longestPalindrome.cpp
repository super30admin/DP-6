// Time complexity: O(n^2)
// Space complexity: O(n^2)
/*
we use the row and cols as the end and start point of the substring 
row -> i -> 0 to n
col -> j -> 0 to i

i == j => true and we update the max and indices 
if s[i] == s[j]
1. Its got letters inbetween and we can find the solution by looking at dp[i-1][j+1]
2. Or its true if the letter intween are 0 or 1 => i.e aba or aa scenarios 

*/
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


// Approach 2: two pointer 
// Time complexity: O(n^2)
// Space complexity: O(1)

/*
iterate over every letter and explode the boundaries and get the maximum palindrome
Re-do the same thing but now take pairs of letter which are the same
*/

class Solution {
public:
    int resultStart, max = -1;
    string longestPalindrome(string s) {
        if(s.length() < 2)
            return s;

        for(int i =0; i < s.length(); i++) {
            expandAround (s, i, i);
            if(i+1 < s.length() && s[i] == s[i+1])
                expandAround (s, i, i+1);
        }

        return s.substr(resultStart, max);
    }
private:
    void expandAround(string s, int start, int end) {
        while (start >= 0 && end < s.length() && s[start] == s[end]) {
            start --; 
            end ++;
        }
        start ++;
        end --; 
        if(end - start + 1 > max) {
            max = end - start + 1;
            resultStart = start;
        }
    }
};