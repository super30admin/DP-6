// Time Complexity :O(n^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    private int start = 0;
    private int end = 0;
    
   public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) 
        return s;
       
    
    for (int i = 0; i < s.length(); i++) {
        helper(s, i, i);
        helper(s, i, i + 1);
    }
        
    return s.substring(start, end + 1);
}

private void helper(String s, int left, int right) {
    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
    {
        left--;
        right++;
    }
    left++;
    right--;
    
    if(right - left > end - start){
        start = left; 
        end = right;
    }
}    

}