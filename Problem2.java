/*

A palindrome mirrors around its center, there are even palindroms and odd length palidromes e.g aa even , aba, oddlength

If we consider each index as a pivot and keep on explanding left and right from the pivot , then we can see if it can make a palindrome , if so we record its length

We will consider if the pivot can be even or odd, so we will try both ways of doing that, and which ever is giving us the longer answer we will use that
 T:2n
 S:1

There is a DP Solution as well

*/

class Solution {
        int start=-1;
        int end = -1;
        int max = Integer.MIN_VALUE;

    public String longestPalindrome(String s) {

        /*
        int n = s.length();

        for(int pivot = 0;pivot<n;pivot++){          
            evenPalindrome(s,pivot); // check if the pivot and its next element are same and taken as pivot
            oddPalindrome(s,pivot); // check if only the pivot is taken as pivot
        }
        
        if(start ==-1 || end==-1){ // if there are no palindromic substring , then return first char
            return s.substring(0,1);
        }
        
        return s.substring(start,end+1);
        */

        // Dp method

        return Dp(s);

    }

    /*

    T: O(n^2)
    S:O(n)
    */

    private String Dp(String s){
        
        int n = s.length();
        boolean[]dp = new boolean[n];

    
        
        for(int j=0;j<n;j++){
            for(int i=0;i<=j;i++){
                if(s.charAt(i) == s.charAt(j)){
                    // check if no characters between i and J
                    if(j-i ==0 ||  j-i == 1){  // if they both point to the single character , or they just have diff of 1
                        dp[i] = true;
                    }
                    else{
                        // check if the subproblem is also true
                        if(i<n-1)
                        dp[i] = dp[i+1];
                        else
                         dp[i] = true;
                    }
                }
                else{
                    dp[i] = false;
                }
                // if true , record the length
                    if(dp[i]){
                        int len = j - i +1;
                        if(len > max){
                            max = len;
                            start = i; end = j;
                        }   
                    }
            }

        }

        if(start ==-1 || end == -1){
            return s.substring(0,1);
        }

        return s.substring(start,end+1);

    }

    private void oddPalindrome(String s, int idx){
         int n = s.length();
            int left = idx -1;
            int right = idx+1;

            // check if the nxt char is same or not
            if(isbounds(idx+1,n) && s.charAt(idx+1) == s.charAt(idx)){
                left = idx;
            }
            // keep on increasing the left and right

            while(isbounds(left,n) && isbounds(right,n) && s.charAt(left) == s.charAt(right)){
                int length = right- left +1;
                if(length>max){
                start = left;
                end = right;
                max = length;
                }
                left--;right++;
            }

    }

    private void evenPalindrome(String s, int idx){
            int n = s.length();
            int left = idx -1;
            int right = idx+1;
            // keep on increasing the left and right
            while(isbounds(left,n) && isbounds(right,n) && s.charAt(left) == s.charAt(right)){
                int length = right- left +1;
                if(length>max){
                start = left;
                end = right;
                max = length;
                }
                left--;right++;
            }
    }

    private boolean isbounds(int idx, int n){
        return (idx >=0 && idx < n);
    }
}