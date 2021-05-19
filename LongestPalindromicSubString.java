class Solution {
    public String longestPalindrome(String s) {
        //sanity check
        if(s == null || s.length() == 0){
            return null;
        }
        int start = 0; int end = 0;
        
        //logic
        for(int i = 0; i < s.length(); i++){
            //to handle odd length palindromes
            int len1 = expandAroundCenter(s,i,i);
            //to handle even length palindromes
            int len2 = expandAroundCenter(s,i,i+1);
            
            int length = Math.max(len1, len2);
            
            //if length of current palindrome is greater than the previous palindromes length
            //update start and end pointers
            if(length > (end-start)){
                start = i - (length-1)/2;
                end = i + (length)/ 2;
            }
        }
        return s.substring(start, end+1);
    }
    
    private int expandAroundCenter(String s, int left, int right){
        if(s == null){
            return 0;
        }
        //trying to expand in both directions to check if we have a palindrome or not
        while(left >= 0 && right < s.length() && left <= right && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        //return length of palindrome found till now
        return right-left-1;
    }
}

//Time Complexity: O(n^2)
//Space Complexity: O(n)