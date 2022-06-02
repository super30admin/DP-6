//Time Complexity O(N*N)
//Space Complexity O(1)
//Leetcode tested

public class LongestPalindromicSubstring {
    int start;
    int end;
    int max;
    int n;
    public String longestPalindrome(String s) {
        if(s==null || s.length() == 0) return s;
        start = 0; end = 0;
        n = s.length();
        for (int i = 0; i < s.length(); i++) {
            extendAroundCharacter(s,i,i);
            if(i < n-1 && s.charAt(i) == s.charAt(i+1)){
                extendAroundCharacter(s,i,i+1);
            }
        }
        return s.substring(start,end+1);
    }
    public void extendAroundCharacter(String s,int left,int right){
        while (left >=0 && right < n && s.charAt(left) == s.charAt(right)){
            left--;right++;
        }
        int aLeft = left+1;
        int aRight = right-1;
        if(aRight - aLeft + 1 > max) {
            max = aRight-aLeft+1;
            start=aLeft;
            end=aRight;
        }
    }
}
