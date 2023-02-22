// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class LongestPalindrome {
    int startIdx;
    int maxLen;
    public String longestPalindrome(String s) {
        for (int i =0;i<s.length();i++){
            findMaxPalindrome(s,i,i);
            findMaxPalindrome(s,i,i+1);
        }
        return s.substring(startIdx, maxLen+startIdx);
    }
    
    public void findMaxPalindrome(String s, int start, int end){
        while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end) ){
            start --;
            end ++;
        }
        if(maxLen < end-start-1){
            maxLen = end-start-1;
            startIdx = start+1;
        } 
    }
}