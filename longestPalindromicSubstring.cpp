/*
//DP Solution
//Time & Space: O(n*2) where n is the size of the string
class Solution {
public:
    string longestPalindrome(string s) {
        int maxVal = 0;
        int start,end;
        vector<vector<bool>> dp(s.length(),vector<bool>(s.length(),false));
        for(int i = 0; i < dp.size();i++){
            for(int j = 0; j <= i;j++){
                if(s[i] == s[j] and (i-j < 2 or dp[i-1][j+1])){
                    dp[i][j] = true;
                    if(i-j+1 > maxVal){
                        maxVal = i-j+1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substr(start,end-start+1);
    }
};
*/
//Two Pointer Solution
//Time : O(n*2) where n is the size of the string
//Space : O(1) no extra space
class Solution {
    int start,end;
    int maxVal = INT_MIN;
public:
    void extendAtCenter(string s, int left,int right){
        while(left >= 0 && right <= s.length()){
            if(s[left] == s[right]){
                left--;
                right++;
            }
            else break;
        }
        left++;
        right--;
        if(maxVal < right-left+1){
            maxVal = right-left+1;
            start = left;
            end = right;
        }
    }
    string longestPalindrome(string s) {
        for(int i = 0; i < s.length(); i++){
            extendAtCenter(s,i,i);
            if(i < s.length() -1 and s[i] == s[i+1]){
                extendAtCenter(s,i,i+1);
            }
        }
        return s.substr(start,end-start+1);
    }
};