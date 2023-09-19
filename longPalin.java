// time complexity : O(n*n)
// space complexity : O(1)

// problem link : https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        String res ="";
        int len = s.length();
        // base case
        if(len == 1)
            return s;

        // logic
        for(int  i = 1; i < len ; i++){
            String curr1 = getPalin(s,i-1, i+1);
            String curr2 = getPalin(s, i-1, i);
            if(curr1.length() < curr2.length())
                curr1 = curr2;
            if(curr1.length()>res.length())
                res = curr1;
        } 
        return res;
    }

    private String getPalin(String s , int i , int j){
        int len = s.length();
        while(i>=0 && j < len){
            if(s.charAt(i) != s.charAt(j))
                return s.substring(i+1,j);
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}
