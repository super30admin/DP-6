class Solution {
    //TC: O(n*n)
    //SC : O(1 )
    int start, end;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int n = s.length();    
        for(int i = 0; i < n-1; i++){
            expand_from_center(i,i,s);
            if(i < n-1 && s.charAt(i) == s.charAt(i+1)){
                expand_from_center(i,i+1,s);
            }
        }
        return s.substring(start,end+1);   
    }

      private void expand_from_center(int left, int right,String s){
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
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
}
