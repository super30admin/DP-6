// Time Complexity: O(n^2) – expand-around-center runs up to O(n) work for each of n centers (odd and even).
// Space Complexity: O(1) – uses constant extra space.

//Iterate each index as a center and expand outward for odd-length palindromes; also expand for even-length using (i, i+1) when applicable.
//During each expansion, move left-- and right++ while characters match to find the maximal palindrome at that center.
//After an expansion stops, update max, start, and end if the found window is longer; return s.substring(start, end+1).

class Solution {
    int max;
    int start, end;

    public String longestPalindrome(String s) {
        int  n = s.length();
        this.max = 0;
        start = 0; end = 0;

        for(int i=0; i<n; i++){
            //odd length
            extendsAround(s, i, i);
            //even length
            if(i < n-1 && s.charAt(i) == s.charAt(i+1)){
                extendsAround(s, i, i+1);
            }
        }

        return s.substring(start, end+1);
    }

    private void extendsAround(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        left++;   
        right--;

        if(max < right-left+1){
            max = right - left + 1;
            start = left;
            end = right;
        }
    }
}
