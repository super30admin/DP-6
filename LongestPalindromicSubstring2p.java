// ## Problem2: (https://leetcode.com/problems/longest-palindromic-substring/)

// Two Pointers
// Time: O(N*N)
// Space: O(1)
// We will traverse the entire string, and at each point expand outwards
// till the pointers point to equal chars

class Solution {
    private int start=0;
    private int end=0;

    public String longestPalindrome(String s) {
        if(s==null || s.length()<=1){
            return s;
        }

        int n = s.length();
        for(int i=0;i<n-1;i++){ //O(N*N)
            // odd length palindrome check
            expand(s, i, i);                    // O(N)
            //even length palindrome check
            expand(s, i, i+1);                  // O(N)
        }
        return s.substring(start, end+1);
    }

    private void expand(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        left++;
        right--;

        // update global if current palindromic substring is longer
        if((right-left)>(end-start)){
            start=left;
            end=right;
        }
    }
}