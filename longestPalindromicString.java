/* 
Time Complexity - O(n * n)
Space Complexity - O(n * n) where n is the length of the string s.
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return s;
        
        int strLen = s.length();
        int[][] paliLen = new int[strLen][strLen];
        int[] result = new int[2];

        for(int i = 0; i < strLen; i++)
            paliLen[i][i] = 1;
        
        for(int i = 0; i < strLen - 1; i++)
            if(s.charAt(i) == s.charAt(i + 1)) {
                paliLen[i][i + 1] = 2;
                result[0] = i;
                result[1] = i + 1;
            }
        
        for(int len = 2; len < strLen; len++)
            for(int start = 0; start < strLen - len; start++) {
                int end = start + len; //row index -> start.     col index -> start + len 
                char firstCh = s.charAt(start), lastCh = s.charAt(end);
                if(firstCh == lastCh && paliLen[start + 1][end - 1] > 0) {
                    paliLen[start][end] = paliLen[start + 1][end - 1] + 2; 
                    result[0] = start;
                    result[1] = end;
                }
            }

        return s.substring(result[0], result[1] + 1);
    }
}
