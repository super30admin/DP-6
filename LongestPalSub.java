/*
method 1 - expand around center 
TC: O(n^2)
SC: O(N^2)

method 2: expand around center
-check for even and odd length substring
TC:O(n^2)
SC:O(1)
*/
class Solution {
    
    //method 1 - 2 pointers to expand around center. 
        
//     public String longestPalindrome(String s) {
        
//         //can solve this problem with 2 pointer approach
        
//         int maxLen = 1;//since a character in itself can be a palindrome
//         int start = 0;int end= 0;
        
//         //since palindrome can be of even and odd lenght, we can try both
        
//         //iterate the string and try to exapnd at each index
        
//         for(int i = 0; i < s.length();i++){
//             //even length
//             int low = i-1;
//             int high = i;
//             //expand around center
//             while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
//                   if(maxLen < high-low+1){
//                     maxLen = high-low+1;
//                     start = low;
//                 }
//                   low--;high++;
//             }
           
//             //odd length
//              low = i-1;
//              high = i+1;
//             //expand around center
//             while(low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)){
//                 if(maxLen < high-low+1){
//                     maxLen = high-low+1;
//                     start = low;
//                 }
//                     low--;high++;
//             }
//         }
//         String res = s.substring(start, start+maxLen);
//         return res;
//     }
     
    //method 2 - dp
    public String longestPalindrome(String s){
         boolean[][]dp = new boolean[s.length()][s.length()];
         
         for(int i = 0;i < dp.length;i++){
             dp[i][i] = true;
         }
         
         int start = 0;
         int end = 0;
         int maxLen = 1;
         
         for(int i = 0;i < dp.length;i++)
         {
             for(int j = 0; j < i ;j++)
             {
                 if(s.charAt(i) == s.charAt(j) && ((i-j) <= 2 || dp[i-1][j+1]))
                 {
                     dp[i][j] = true;
                     if(maxLen < i- j + 1){
                             maxLen = i - j + 1;
                             start = j;
                    }
                 }
            }
          }
             
         
         
         String res = s.substring(start,start+maxLen);
         return res;
     }
}