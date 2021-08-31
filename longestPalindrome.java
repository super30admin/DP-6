// Time Complexity : O(N^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int start,end,max;
    private void expandLeftRight(String s,int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        left++;
        right--;
        if(right-left+1 > max){
            start = left;
            end = right;
            max = right-left+1;
        }
    }
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        for(int i = 0 ; i < s.length()-1; i++){
            expandLeftRight(s,i,i);
            expandLeftRight(s,i,i+1);
        }
        return s.substring(start,end+1);
    }
}