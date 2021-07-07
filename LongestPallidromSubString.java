

/*

Approach - 1
DP

To improve over the brute force solution, we first observe how we can avoid unnecessary re-computation while validating palindromes. Consider the case "ababa". If we already knew that "bab" is a palindrome, it is obvious that "ababa" must be a palindrome since the two left and right end letters are the same.

We define P(i,j)P(i,j) as following:

P(i,j) = \begin{cases} \text{true,} &\quad\text{if the substring } S_i \dots S_j \text{ is a palindrome}\\ \text{false,} &\quad\text{otherwise.} \end{cases}P(i,j)={ 
true,
false,
​	
  
if the substring S 
i
​	
 …S 
j
​	
  is a palindrome
otherwise.
​	
 

Therefore,

P(i, j) = ( P(i+1, j-1) \text{ and } S_i == S_j )P(i,j)=(P(i+1,j−1) and S 
i
​	
 ==S 
j
​	
 )

The base cases are:

P(i, i) = trueP(i,i)=true

P(i, i+1) = ( S_i == S_{i+1} )P(i,i+1)=(S 
i
​	
 ==S 
i+1
​	
 )

This yields a straight forward DP solution, which we first initialize the one and two letters palindromes, and work our way up finding all three letters palindromes, and so on...

Approach-2
In fact, we could solve it in O(n^2)
 ) time using only constant space.

We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2n - 12n−1 such centers.

You might be asking why there are 2n - 12n−1 but not nn centers? The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
*/

public class LongestPallidromSubString {
    public String longestPalindrome(final String s) {
        final int size = s.length();

        final boolean[][] dp = new boolean[size][size];
        int start = 0, end = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j - 1])) {
                    dp[i][j] = true;
                    if (i - j > (end - start)) {
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    int maxLen = 0, start = 0;

    public String longestPalindrome2(final String s) {
        final int size = s.length();
        if (size < 2) {
            return s;
        }
        for (int i = 0; i < size - 1; i++) {
            extendPallindrome(s, i, i);
            extendPallindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);

    }

    public void extendPallindrome(final String s, int i, int j) {
        while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if(maxLen <  (j - (i + 1))){
            maxLen = j - (i + 1);
            start = i + 1;
        }
    }
}