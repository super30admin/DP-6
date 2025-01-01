// Brute force is gonna be O(n^3).
// This is better.
// Time complexity = O(n^2)
// Space complexity = O(n)
// the idea is to get every index and expand from there towards left and towards right.
class Solution {
    int start;
    int end;
    public String longestPalindrome(String s) {
        // start from each index and expand towards the left and right index.
        int n = s.length();
        for(int i=0;i< n;i++) {
            extendAroundCenter(s,i,i);// badab// odd length .
            if(i< n-1 && s.charAt(i) == s.charAt(i+1)) {
                // move your right pointer by 1 to the right.
                extendAroundCenter(s,i,i+1);// baddab // even length
            }
        }
        return s.substring(start, end +1 );
    }

    private void extendAroundCenter(String s, int left, int right) {
        while(left >=0 && right< s.length() && s.charAt(left)== s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;
        if(right-left > end-start) {
            start = left;
            end = right;
        }
    }
}