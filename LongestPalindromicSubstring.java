// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    
    int max=0;
    String res ="";
    
     public String longestPalindrome(String s) {
         if(s==null || s.length()==0)
             return "";
         
         int start=0;
         int end=0;
         for(int i=0; i<s.length(); i++){
             checkPal(s, i, i);
             checkPal(s, i, i+1);
         }
         return res;
     }
    
    private void checkPal(String s, int start, int end){
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
             if(end - start + 1 > max){
                 max = end - start + 1;
                 res = s.substring(start, end+1);
             }
             start--;
             end++;
         }
    }
       
}