// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Approach: DP 


class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        bool dp[n][n];
        memset(dp,false,sizeof(dp));
        int start = 0,end = 0;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=i;j++){
                if(i==j){
                    dp[i][j] = true;
                }
                else if((s[i]==s[j]) && i-j==1){
                    if(i-j > end-start){
                        start = j;
                        end = i;
                    }
                        dp[i][j] = true;
                }
                else if((s[i]==s[j]) && (dp[i-1][j+1]==true)){
                    if(i-j > end-start){
                        start = j;
                        end = i;
                    }
                    dp[i][j] = true;
                }
            }
        }
        return s.substr(start,end-start+1);
    }
};

// Approach: Expanding around the centres.
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int start = 0,end = 0;
    string longestPalindrome(string s) {
        int n = s.size();
        for(int i = 0;i<n-1;i++){
            solve(s,i,i);
            solve(s,i,i+1);
        }
        return s.substr(start,end-start+1);
    }
    void solve(string& s, int j, int i){
        while(j>=0 && i<s.size()){
            if(s[i]!=s[j]) break;
            i++;
            j--;
        }
        i--;j++;
        if(end-start< i-j){
            start = j;
            end = i;
        }
    }
};