import java.util.Scanner;

public class LongestPalindromicSubstringTwoPointers {

        // Memoization 1D array - Dynamic Programming - Time O(n*n) and Space O(1)

        int start, end, n;
        String s;

        public String longestPalindrome(String s) {

            this.s = s;
            this.n = s.length();

            // null case
            if(n == 0) {
                return null;
            }

            // limits of the longest palindromic substring initially
            this.start = 0;
            this.end = 0;

            // iterate over characters of string s
            for(int i = 0; i < n; i++) {        // O(n)

                // initially both left and right pointers are at the index itself
                checkAround(i, i);              // O(n)

                // edge case - even length string
                // adjacent characters will be equal in case of even length palindromic centre
                if(i < n-1 && s.charAt(i) == s.charAt(i+1)) {

                    // separate left and right pointers by one character and extend
                    checkAround(i, i+1);
                }
            }

            // output
            return s.substring(start, end + 1);
        }

        public void checkAround(int left, int right) {

            // pointers in bound and characters match
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {

                // move outwards
                left--;
                right++;
            }

            // bring pointers back, after breach, in bounds by moving inward
            right--;
            left++;

            // compare current and existing longest palindromic substring lengths and update

            int maxLength = end - start + 1;
            int currLength = right - left + 1;

            if(currLength > maxLength) {

                start = left;
                end = right;
            }
        }

        public static void main(String[] args) {

            LongestPalindromicSubstringTwoPointers obj = new LongestPalindromicSubstringTwoPointers();
            Scanner scanner = new Scanner(System.in);

            System.out.println("string: ");
            String s = scanner.nextLine();

            String answer = obj.longestPalindrome(s);

            System.out.println("the longest palindromic substring is " + answer);
        }

}

/*
Time Complexity = O(n*n)
Space Complexity = O(1)
*/