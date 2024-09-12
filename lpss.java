//o(n^2) time and space complecities
//used dynamic prograpmming
//passed all leetcode cases

class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length() ==0) return s;
        int n = s.length();
        boolean[][] grid = new boolean[n][n];
        int len = 1;
        for(int i=0;i<n;i++){
            grid[i][i] = true;
        }
        len = 2;
        int start = 0, end = 0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                grid[i][i+1] = true;
                start = i;
                end = i+1;

            }
        }
        for(len = 3;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                int j = i+len-1;
                if(grid[i+1][j-1]&&s.charAt(i) == s.charAt(j)){
                    grid[i][j]=true;
                    start = i;
                    end = j;
                }
            }

        }
        return s.substring(start,end+1);

    }
}