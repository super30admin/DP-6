# DP-6

## Problem1: (https://leetcode.com/problems/ugly-number-ii/)

//Time Complexity = O(N)
//Space Complexity = O(N)

class Solution {
public int nthUglyNumber(int n) {
if(n == 1) {
return 1;
}
int[] dp = new int[n];
dp[0] = 1;
int n2 = 2;
int n3 = 3;
int n5 = 5;
int p2 = 0;
int p3 = 0;
int p5 = 0;

        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(n2, Math.min(n3,n5));
            if(dp[i] == n2) {
                p2++;
                n2 = dp[p2] * 2;
            }
            if(dp[i] == n3) {
                p3++;
                n3 = dp[p3] * 3;
            }
            if(dp[i] == n5) {
                p5++;
                n5 = dp[p5] * 5;
            }
        }
        return dp[n-1];
    }

}

## Problem2: (https://leetcode.com/problems/longest-palindromic-substring/)

//Time Complexity = O(N^2)
//Space Complexity = O(1)

class Solution {
int maxlength;
int start;
int end;
public String longestPalindrome(String s) {
if(s == null || s.length() == 0) {
return "";
}
int n = s.length();

        for(int i = 0 ; i < n; i++) {
            calculateSubstring(s,i,i);
            if(i+1 < n && s.charAt(i) == s.charAt(i+1));
            calculateSubstring(s,i,i+1);

        }
        return s.substring(start, end + 1);
    }

    private void calculateSubstring(String s, int left, int right) {
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;
        if(maxlength < right - left + 1) {
            maxlength = right - left + 1;
            start = left;
            end = right;
        }
    }

}
