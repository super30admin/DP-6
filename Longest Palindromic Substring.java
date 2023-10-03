// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
//We will iterater through the string, select each character and put a left and right pointer 
// on that character. Move the left and right pointers outwards , until we come across the characters 
// which are not similar. When the length of a palindrome is even, then in the center we will have two 
// same characters. In that case we will check if the character next to the current character is the same, 
// the me move the right pointer one step ahead

class Solution {
    int start,end;
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0) return "";
        int n=s.length();
       // iterating through the string
        for(int i=0;i<n;i++)
        {
            extendsAround(s,i,i);
            if(i<n-1 && s.charAt(i)==s.charAt(i+1))
            {
                extendsAround(s,i,i+1);
            }
        }
        return s.substring(start,end+1);
    }

    private void extendsAround(String s, int left, int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
            {
                left--;
                right++;
            }

            left++;
            right--;

            //comparing the length of the current word with the length of the previous word
            if(right-left > end-start)
            {
                start=left;
                end=right;
            }
    }
}

//DP: We will maintain a 2-D matrix and use two pointers i and j. We move j until it reaches i and check update the boolean matrix to true if the character at i = character at j. We will check this until i and j both reach the end of the string . Thoughout the process whenever we get a bigger substring from the previous one, we will keep updating the value of start and end variables.


class Solution {
    int start,end;
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0) return "";
        int n=s.length();
       boolean[][]dp=new boolean[n][n];
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<=i;j++)
           {
               if(s.charAt(i)==s.charAt(j))
               {
                   if(i-j<2 || dp[i-1][j+1])
                   {
                       dp[i][j]=true;
                        if(end-start<i-j)
                        {
                            start=j;
                            end=i;
                        }
                   }
                   else
                    {
                        dp[i][j]=false;
                    }
               }

               else
               {
                   dp[i][j]=false;
               }
           }
       }
       return s.substring(start,end+1);
    }
}
