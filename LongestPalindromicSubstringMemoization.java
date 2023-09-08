import java.util.Scanner;

public class LongestPalindromicSubstringMemoization {

        // Memoization - Dynamic Programming - Time O(n*n) and Space O(n*n)

        public String longestPalindrome(String s) {

            int n = s.length();

            if(n == 0) {
                return null;
            }

            // limits of the longest palindromic substring
            int start = 0;
            int end = 0;

            int max = 1;

            // memoization array
            boolean[][] dp = new boolean[n][n];          // O(n*n) space
            dp[0][0] = true;

            // start i iterator from second letter of string s
            for(int i = 1; i < n; i++) {                 // O(n*n)

                // j iterator runs from first to ith letter of string s
                for(int j = 0; j <= i; j++) {

                    // if characters match
                    if(s.charAt(i) == s.charAt(j)) {

                        // if diagonal upright dp element is true
                        if(i-j < 2 || dp[i-1][j+1]) {

                            // make current dp element true
                            dp[i][j] = true;

                            // length of palindromic substring
                            int currLength = i - j + 1;

                            // update the longest palindromic substring length and extent
                            if(currLength > max) {

                                max = currLength;

                                start = j;
                                end = i;
                            }
                        }
                    }
                }
            }
            // output
            return s.substring(start, end + 1);
        }

        public static void main(String[] args) {

            LongestPalindromicSubstringMemoization obj = new LongestPalindromicSubstringMemoization();

            Scanner scanner = new Scanner(System.in);

            System.out.println("string: ");
            String s = scanner.nextLine();

            String answer = obj.longestPalindrome(s);

            System.out.println("the longest palindromic substring is " + answer);

        }

}

/*
Time Complexity = O(n*n)
Space Complexity = O(n*n)
*/

