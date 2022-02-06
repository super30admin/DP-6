class Solution {
    public int nthUglyNumber(int n) {
        //o(n) time & o(n) space
        if( n == 1 )return 1;
        int p2 = 0; int p3 = 0; int p5 = 0;
        int n2 = 2; int n3 = 3; int n5 = 5;
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Math.min(n2, Math.min(n3, n5));
            result[i] = min;
            if(min == n2){
                p2++;
                n2 = result[p2] * 2;
            }if(min == n3){
                p3++;
                n3 = result[p3] * 3;
            }if(min == n5){
                p5++;
                n5 = result[p5] * 5;
            }
        }
        return result[n-1];
    }

    public String longestPalindrome(String s) {
            //o(n^2) time and o(n^2) space
            if(s ==null || s.length() == 0) return s;
            int start = 0; int end = 0;
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j <= i; j++){
                    if(s.charAt(i) == s.charAt(j) && ((i - j) < 2 || dp[i-1][j+1])){
                        dp[i][j] = true;
                        if(i - j > end - start){
                            start = j;
                            end = i;
                        }
                    }
                }
            }
            return s.substring(start, end + 1);
            
            
        }

    int start; int end; int n; 
    public String longestPalindrome2(String s) {
        //o(n^2) time & constant space
                n = s.length();
                if(s == null || n == 0)return s;
                for(int i = 0; i  < n; i++){
                    extend(s, i, i);
                    if(i < n -1 && s.charAt(i) == s.charAt(i+1)){
                        extend(s, i, i+ 1);
                    }
                }
                return s.substring(start, end + 1);
            }
            private void extend(String s, int l, int r){
                
                while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                    l--; r++;
                }
                l++; r--;
                if(r - l > end- start){
                    start = l;
                    end = r;
                }
                
            }
        
}