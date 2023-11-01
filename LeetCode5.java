// Time Complexity : O(n2) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int start, end;
    public String longestPalindrome(String s) {
        if(s==null|| s.length()==0) return "";
        for(int i=0; i< s.length();i++){  //O(n)
            extendAroundCenter(s,i,i); // odd length
            //middle chars can be same which can lead to even len palindrome
            if(i < s.length()-1 && (s.charAt(i)== s.charAt(i+1))){
                extendAroundCenter(s,i,i+1); // so take right = i+1 instead of i
            }
        }
        return s.substring(start,end+1);
    }
    private void extendAroundCenter(String s, int l, int r){
        //O(n)
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){//if chars are same and indexes are inbound
            l--;
            r++;
        }
        l++;  // increase for inbound
        r--;  // decrease for inbound
        
        if( r-l > end-start ){
           start = l ;   // update indexes if length of substring is > prev len
            end = r;
            
        }
    }
}