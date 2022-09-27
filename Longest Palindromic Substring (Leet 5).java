

class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        dp[0][0] = true;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if (s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[i-1][j+1])){                    
                    
                    dp[i][j] = true;
                    if (end - start < i - j){
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}


/////////


class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int n = s.length();
        boolean [] dp = new boolean[n];
        dp[0] = true;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if (s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[j+1])){                    
                    
                    dp[j] = true;
                    if (end - start < i - j){
                        start = j;
                        end = i;
                    }
                }else{
                    dp[j] = false;
                }
            }
        }
        System.out.println(dp[n-1]);
        return s.substring(start, end+1);
    }
}



//////

// check again for efficient solution

// #Time complexity: O(n^2)
// #Space compelxity: O(1)
// class Solution:
//     def longestPalindrome(self, s: str) -> str:
//         max_start,max_end=0,0
//         for i in range(len(s)):
//             mid=i
//             even_start,even_end=self.palindrome(s,mid,mid+1)
//             odd_start,odd_end=self.palindrome(s,mid-1,mid+1)
//             if((even_end-even_start-1) < (odd_end-odd_start-1)):
//                 start=odd_start
//                 end=odd_end
//             else:
//                 start=even_start
//                 end=even_end
//             if(end-start-1>max_end-max_start-1):
//                 max_start=start
//                 max_end=end
//         return s[max_start+1:max_end]
//     def palindrome(self,s,left,right):
//         while(left>=0 and right<len(s) and s[left]==s[right]):
//             left-=1
//             right+=1
//         return [left,right]
