// time: O(N^2) | Space: O(N)

//pointers soln

class Solution {
    int start , end;

    public String longestPalindrome(String s) {
        int center = 0;
        start = 0;
        end = 0;
        int n = s.length();
        while(center < n) {
            extendAroundCenter(s, center, center,n);
            if(center < n-1 && s.charAt(center) == s.charAt(center+1)) extendAroundCenter(s, center, center+1,n);
            center++;
        }
        return s.substring(start, end+1);
    }
    private void extendAroundCenter(String s, int l, int r, int n){
        while(l>=0 && r <n && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        r--;
        if(r-l > end-start) {
            start = l;
            end = r;
        }

    }
}

// dp soln
// time: O(N) | Space: O(N^2)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int start = 0, end = 0;
        for(int i=1;i<n;i++) {
            for(int j=0;j<=i;j++) {
                if(s.charAt(i) == s.charAt(j) && (i-j <=2 || dp[j+1])){
                    dp[j] = true;
                    if(end-start < i-j) {
                        end = i;
                        start = j;
                    }
                } else dp[j] = false;
            }
        }
        return s.substring(start,end+1);
    }
}