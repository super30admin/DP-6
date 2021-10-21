
/* 
TC = O(n2)
SC = O(n2)

*/
/* 
TC = O(n2)
SC = O(1)

*/
class LongestPalindromSubstringsol2 {
    int max , start, end ;
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() == 0 ) return "" ;
        
        int n = s.length();
        for( int i = 0 ; i < n ; i ++){
            //This should take care of odd length palindromic substring;
            expandAround(s,i,i);
            if ( i +1 < n && s.charAt(i) == s.charAt(i + 1)){
                //This should take care of even length palindromic substring;
                expandAround(s,i,i +1);
            }
        }
        return s.substring(start, end + 1);
    }
    private void expandAround( String s, int left , int right){
        while ( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        left ++ ;
        right --;
        if (right - left + 1 > max) {
            max = right - left + 1 ;
            start = left ;
            end = right ;
        }
    }
}