// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// There can be an even length palindrome or of odd length
// For both the cases we will iterate over each of the charater with that as starting point
// We will continue expanding if we see left char and right char to that string are equal
// We will maintain the max start and end to have the max length
// Finally we will return the substring with max length
class Solution {
    int maxStart, maxEnd;
    public String longestPalindrome(String s) {
        maxStart = 0;
        maxEnd = 0;
        for(int i = 0; i < s.length(); i++){
            explore(s, i, i+1); // even
            explore(s, i, i); //odd
        }
        return s.substring(maxStart, maxEnd + 1);
    }
    private void explore(String s, int i, int j){
        if(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            if((maxEnd - maxStart) < (j - i)){
                maxStart = i;
                maxEnd = j;
            }
            i--;
            j++;
            explore(s, i, j);
        }
    }
}