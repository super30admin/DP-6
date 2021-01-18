//Time Complexity - O(n^2)
//Space Complexity - O(1)

class Solution {
    int max = 0;
    int start = 0;
    public String longestPalindrome(String s) {
        int n = s.length();    
        for(int i = 0; i < s.length(); i++){
            extendAround(s, i,i);
            if(i < n -1 && s.charAt(i) == s.charAt(i+1)){
                extendAround(s, i, i+1);
            }
        }
        return s.substring(start,start+max);   
    }
    
    private void extendAround(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if(right - left - 1 > max){
            max = right -left -1;
            start = left + 1;
        }
    }
}