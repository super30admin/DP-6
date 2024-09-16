/*
The time complexity is O(n^2) and the space complexity is also O(n^2) where n is the length of the given string s

Here to avoid calculating the subproblem again and again we maintain a dp array. So the intuition is for example we see that character
at index i == character of index j of a given string. Then to consider it as a palindrome substring of length i+1 to j-1 should also
be a palindrome which we will be storing in our dp array.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public String longestPalindrome(String s) {

        int len = s.length();

        if(len<=1){return s;}
        boolean dp[][] = new boolean[len][len];

        int max = 0; int id1 = 0; int id2 = 0;

        for(int end=0;end<len;end++){

            for(int start = 0;start<end;start++){

                if(s.charAt(start)==s.charAt(end)){

                    //If the substring length is less than or equal to 3 than or substring of length start+1 to end-1 is palindrome
                    //then the present substring will also be a palindrome.
                    if(end-start+1<=3 || dp[start+1][end-1]){
                        dp[start][end] = true;
                        if(end-start+1>max){
                            max = end-start+1;
                            id1 = start; id2 = end;
                        }
                    }
                }
            }
        }

        return s.substring(id1,id2+1);
    }
}