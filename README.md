# DP-6
    
## Problem1: (https://leetcode.com/problems/ugly-number-ii/)
class Solution {
public:
    int nthUglyNumber(int n) {
        int ans[n];
        ans[0] = 1;
        int i2=0, i3=0, i5=0;
        int i, mul2 = ans[i2]*2, mul3 = ans[i3]*3, mul5 = ans[i5]*5, aa = 1;
        for(i=1;i<n;i++){
            aa = min(mul2, min(mul3, mul5));
            ans[i] = aa;
            if(aa==mul2){
                i2 = i2 + 1;
                mul2 = ans[i2] * 2;
            }
            if(aa==mul3){
                i3 = i3 + 1;
                mul3 = ans[i3] * 3;
            }
            if(aa==mul5){
                i5 = i5 + 1;
                mul5 = ans[i5] * 5;
            }
        }
        return aa;
    }
};
   
## Problem2: (https://leetcode.com/problems/longest-palindromic-substring/)


class Solution {
public:
    string longestPalindrome(string str) {
        if (str.length() < 2) {
                return str;
  }
        int maxLength = 1; 
  
    int start = 0; 
    int len = str.length(); 
  
    int low, high; 
  
    // One by one consider every 
    // character as center point of 
    // even and length palindromes 
    for (int i = 1; i < len; ++i) { 
        // Find the longest even length palindrome 
        // with center points as i-1 and i. 
        low = i - 1; 
        high = i; 
        while (low >= 0 && high < len 
               && str[low] == str[high]) { 
            if (high - low + 1 > maxLength) { 
                start = low; 
                maxLength = high - low + 1; 
            } 
            --low; 
            ++high; 
        } 
  
        // Find the longest odd length 
        // palindrome with center point as i 
        low = i - 1; 
        high = i + 1; 
        while (low >= 0 && high < len 
               && str[low] == str[high]) { 
            if (high - low + 1 > maxLength) { 
                start = low; 
                maxLength = high - low + 1; 
            } 
            --low; 
            ++high; 
        } 
    }
        int i;
    string ans="";
        for(i=start;i<(start+maxLength);i++)
            ans+=str[i];
        return ans;
    }
};
