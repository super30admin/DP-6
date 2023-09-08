import java.util.Scanner;

public class LongestPalindromicSubstringMemoization1D {

        // Memoization 1D array - Dynamic Programming - Time O(n*n) and Space O(n)

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
            boolean[]dp = new boolean[n];          // O(n*n) space
            dp[0] = true;

            // start i iterator from second letter of string s
            for(int i = 1; i < n; i++) {                 // O(n*n)

                // j iterator runs from first to ith letter of string s
                for(int j = 0; j <= i; j++) {

                    // if characters match
                    if(s.charAt(i) == s.charAt(j)) {

                        // if diagonal upright dp element is true
                        if(i-j < 2 || dp[j+1]) {

                            // make current dp element true
                            dp[j] = true;

                            // length of palindromic substring
                            int currLength = i - j + 1;

                            // update the longest palindromic substring length and extent
                            if(currLength > max) {

                                max = currLength;

                                start = j;
                                end = i;
                            }
                        }

                        else {
                            dp[j] = false;
                        }
                    }

                    else {
                        dp[j] = false;
                    }
                }
            }
            // output
            return s.substring(start, end + 1);
        }

        public static void main(String[] args) {

            LongestPalindromicSubstringMemoization1D obj = new LongestPalindromicSubstringMemoization1D();
            Scanner scanner = new Scanner(System.in);

            System.out.println("string: ");
            String s = scanner.nextLine();

            String answer = obj.longestPalindrome(s);

            System.out.println("the longest palindromic substring is " + answer);
        }

}

/*
Time Complexity = O(n*n)
Space Complexity = O(n)
*/

