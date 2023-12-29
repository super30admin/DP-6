// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int start;
    int end;
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++){
            helper(s,i,i);
            if(i < s.length() - 1 && s.charAt(i)==s.charAt(i+1))
                helper(s,i,i+1);
        }
        return s.substring(start,end+1);
    }
    public void helper(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        l++;
        r--;
        if(end - start < r - l){
            end = r;
            start = l;
        }
    }
}