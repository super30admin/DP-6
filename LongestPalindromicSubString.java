// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class LongestPalindromicSubString {

    int start,end;
    int n;
    public String longestPalindrome(String s) {
        n = s.length();
        for(int i=0; i<n; i++){
            extendsAround(s,i,i); // odd length
            if(i<s.length()-1 && s.charAt(i) == s.charAt(i+1))
                extendsAround(s,i,i+1);  // even length
        }

        return s.substring(start,end+1);
    }

    private void extendsAround(String s, int left, int right){

        while(left>=0 && right < n && s.charAt(left) == s.charAt(right)){
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
