// Time Complexity O(n^2) O(n) for traversal and O(n) for palindrome check
// Space Complexity O(1) - Constant space
public class LongestPalindrome {
    public static String longestPalindrome(String s){
        if( s == null || s.length() <1){
            return "";
        }
        int start =0, end = 0;

        for( int i =0; i < s.length(); i++){
           // With single character center- odd length palindrome
            int len1 =  expandAroundCenter( s, i , i);
            int len2 = expandAroundCenter(s, i, i +1);

            int maxLen = Math.max(len1, len2);

            if( maxLen > end - start ){
                start = i - (maxLen -1)/2;
                end = i + (maxLen)/2;
            }
        }
        return s.substring(start, end +1);

    }

    private static int expandAroundCenter(String s, int left, int right){
        while( left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }

        return right - left -1;
    }

    public static void main( String [] args){
        LongestPalindrome solution = new LongestPalindrome();
        String s1 = "babad";
        System.out.println(solution.longestPalindrome(s1)); // Output: "bab" or "aba"

        String s2 = "cbbd";
        System.out.println(solution.longestPalindrome(s2)); // Output: "bb"

        String s3 = "a";
        System.out.println(solution.longestPalindrome(s3)); // Output: "a"

        String s4 = "ac";
        System.out.println(solution.longestPalindrome(s4)); // Output: "a" or "c"
    }
}
