/**
 * Finds the longest palindromic substring in a given string.
 * Expands around each character (and pair) to check for palindromes.
 * Returns the longest substring found that is a palindrome.
 */
// Time Complexity: O(N^2), where N is the length of the string
// Space Complexity: O(1), since only constant extra space is used
public class LongestPalindromicSubstric {
    public String longestPalindrome(String s) {
        String maxLengthString = "";

        for (int i = 0; i < s.length(); i++) {
            String oddLength = checkPalindrome(i, i, s);
            String evenLength = checkPalindrome(i, i+1, s);
            
            if (oddLength.length() > maxLengthString.length()) {
                maxLengthString = oddLength;
            }
            if (evenLength.length() > maxLengthString.length()) {
                maxLengthString = evenLength;
            }
        }    
        return maxLengthString;
    }

    private String checkPalindrome(int i, int j, String s) {
        while (i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
