// Time Complexity : O(n * n)
// Space Complexity : O(1)

class Solution {
    int max;
    int start, end;
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty())
            return "";
        int n = s.length();
        for(int i = 0; i < n; i++){
            //odd case
            extendAroundCenter(s, i, i);
            //even case
            if(i < n - 1 && s.charAt(i) == s.charAt(i + 1))
                extendAroundCenter(s, i, i + 1);
        }
        return s.substring(start, end + 1);
    }
    
    public void extendAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        left++;
        right--;
        if(right - left + 1 > max){
            start = left;
            end = right;
            max = right - left + 1;
        }
    }
}