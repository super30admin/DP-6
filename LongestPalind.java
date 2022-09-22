// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class LongestPalind {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";
        int start = 0, end = 0;
        int len=0;
        for(int i=0;i<s.length();i++){
            int len1 = expandFromCenter(s,i,i);
            int len2 = expandFromCenter(s,i,i+1);
            if(len1>len2){
                len = len1;
            }
            else{
                len = len2;
            }
            if(len>end-start){
                start=i-((len-1)/2);
                end=i+(len/2);
            }
        }

        return s.substring(start,end+1);
    }

    private int expandFromCenter(String s,int left,int right){
        int l=left, r=right;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }

        return r-l-1;
    }
}