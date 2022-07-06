/* 
    Time Complexity                              :  dynamicProgramming - O(N^2)
                                                    checkPal - O(n^2)
    Space Complexity                             :  dynamicProgramming - O(N^2)
                                                    checkPal - O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
private: 
    int mx, start, n;
public:
    string longestPalindrome(string s) {
        mx = 0, start = 0;
        n = s.size();
        // return dynamicProgramming(s);
        return checkPal(s);
    }
    
    // TC - O(N^2), 
    // SC - O(1)
    string dynamicProgramming(string s) {
        string ans = "";
        vector<vector<bool>> dp(n,vector<bool>(n,false));
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                
                if(s[i] == s[j]) {
                    if(i-j-1 <= 1 or dp[i-1][j+1] == true) {
                        dp[i][j] = true;
                        if(mx < i-j+1) {
                            mx = i-j+1;
                            start = j;
                        }
                    }
                }
            }
        }
        return s.substr(start,mx);
    }
    
    
    // TC - O(n^2), 
    // SC - O(1)
    string checkPal(string s) {
        
         for(int i=0;i<n;i++) {
            expandAroundCenters(s,i,i);
            if(i < n-1 and s[i] == s[i+1]){
                expandAroundCenters(s,i,i+1);
            }
         }    
        return s.substr(start,mx);
    }
    
    
    void expandAroundCenters(string s, int left, int right) {
        
        while(left >= 0 and right < n and s[left] == s[right]) {
            left--;
            right++;
        }
        
        left++;
        right--;
        int len = right - left + 1;
        if(len > mx) {
            mx = len;
            start = left;
        }
    }
};