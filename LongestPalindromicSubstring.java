class LongestPalindromicSubstring {

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)

    private int start = 0;
    private int end = 0;
    
    private void expand(String s, int left, int right){
        while(left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)){
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
    
    public String longestPalindrome(String s) {        
        // EXPAND AROUND CENTRE - Dynamic Programming.
        if (s == null || s.length() == 0 || s.length() <= 1)
            return s;
        
        for(int i = 0; i < s.length(); i++){
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(start, end+1);
    }
}