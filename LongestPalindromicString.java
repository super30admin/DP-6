//DP method

class Solution {

    //TC = 0(n^2) where n is the length of the string
    //SC = 0(n^2)

    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0){
            return "";
        }

        int n = s.length();
        boolean [][] dp = new boolean[n][n];    //a boolean dp array which will store true if it is a palindrome and false if not
        int max = 0;    //to capture the max length of the palindrome sunstring I encounter
        int start = 0;  //stores the start index of the max palindromic substring
        int end = 0;    //stores the end index of the max palindromic substring

        for(int i = 0; i < n; i++){ //starts from 0 and goes upto to length of the string
            for(int j = 0; j <= i; j++){    //starts from 0, goes up to i and ince its equal it again rewinds to 0
                if(s.charAt(i) == s.charAt(j) && ((i - j - 1 <= 1) || dp[i-1][j+1])){   //if the character matches, then I check how many elelemts are there in between, If 1, there it is surely a palindrome. If there are more than 1 characters in between, I checks the value on upper right diagonal whihc I have already computed
                    dp[i][j] = true;    //store true if 1st condition is met and either of the two for 2nd case
                    if(max < i - j + 1){    //also I check if current max is greater than prev max, I change my max
                        max = i - j + 1;
                        start = j;  //store the start index of the substring
                        end = i;    //as well as end
                    }
                }
            }
        }

        return s.substring(start, end + 1); //return the largest palindromic substring
    }
}

//Optimization on space taking 2 pointers

class Solution {

    //TC = 0(n^2) where n is the length of the string
    //SC = 0(1)

    int start, end, max;    //stores the length of max substring, start and end position of the max substring
    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0){
            return "";
        }

        for(int i = 0; i < s.length(); i++){    //starts from 0 and goes up to the length of the string
            PalindromicSubstring(s, i, i);  //if the tring length is odd, then this captures it.
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){ //if the length of the string is even, this will capture it. For palindromic string, 2 adjacent characters has to be same. Hence it catches for even case
                PalindromicSubstring(s, i, i+1);
            }
        }

        return s.substring(start, end + 1);
    }

    public void PalindromicSubstring(String s, int left, int right){

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){    //I use the expansion algo. Here, the left and right pointer expands in their particular direction from ith position capturing the largest palindromic substring
            left--; //I keep on increasing the left subarray
            right++;    //also keep increasing the right subarray
        }

        left++; //when my while loop is exited, either left pointer or right pointer is out of bounds or both can be, so my last largest palindromic substring is captured in last position it was in
        right--;    //hence I get my left and right pointer to my last position

        if(right - left + 1 > max){ //of the substring is greater than previous largest substring found, then I record it
            max = right - left + 1;
            start = left;
            end = right;
        }
    }
}