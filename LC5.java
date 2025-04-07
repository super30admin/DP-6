// TC: O(n^2)
// SC: O(n^2)
// Approach: DP

public class LC5 {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0) return "";
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int max = 0;
        int st = 0, en = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j) && (i==j || j+1==i || dp[i-1][j+1])){
                    dp[i][j] = true;
                    if(i-j+1 > max){
                        max = i-j+1;
                        st = j;
                        en = i;
                    }
                }
            }
        }
        return s.substring(st, en+1);
    }
}

// TC: O(n^2)
// SC: O(1)
// Approach: Expand Around Center

class LC5_2 {
    public String longestPalindrome(String s) {
        int N = s.length();
        int max = 0, p = 0, q = 0;
        for (int i = 0; i < N; i++) {
            int j = i, k = i;
            while (j >= 0 && k < N && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            int val = k - j - 1;
            if (val > max) {
                max = val;
                p = j + 1;
                q = k - 1;
            }
            j = i;
            k = i + 1;
            while (j >= 0 && k < N && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            val = k - j - 1;
            if (val > max) {
                max = val;
                p = j + 1;
                q = k - 1;
            }
        }
        return s.substring(p, q + 1);
    }
}