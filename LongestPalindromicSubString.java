// Approach : Traverse through the whole string and at each and every position of the string , try to extend the window
// and check for palindrome. We would continue to do this by maintaining two pointers at same place for odd length.
// for even length we have pointers adjacent (adjacent characters are same). We will perform this without checking the length.
// Time : O(n^2)
// Space :
class Solution {
    int max;
    int start,end;
    public String longestPalindrome(String s) {
        int n = s.length();
        this.max =0;
        for(int i=0;i<n;i++){
            // check at each character if we are able to perform palindrome or not
            extendsAround(s,i,i); // in case of odd length palindrome. left and right pointers are same.
            if(i< n-1 && s.charAt(i) == s.charAt(i+1)){
                // even length  palindrome
                extendsAround(s, i, i+1); // left and right pointers adjacent
            }
        }

        return s.substring(start,end+1);
    }

    private void extendsAround(String s, int left , int right){
        // left and right at same location
        while(left >=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            right ++;
            left --;
        }

        // left and right not matching - so bring back them inbounds
        left++;
        right--;

        if(max<right - left){
            start = left;
            end = right;
            max = right - left;
        }
    }
}


// Approach : Using DP -  as we have repeated sub problem
// Time : O(n^2)
// Space : O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start =0, end =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                // check if the substring between them is a palindrome or not
                    // case 1 -> i-j =1: 
                    // j i
                    // b b a b b -> substring is palidrome or not - not required

                    // case 2 -> i -j =0: 
                    // j i 
                    //   b b a b b --> substring is palindrome or not - not required

                    // case 3 -> i - j > 1
                    // j      i
                    // b b a b b
                if(s.charAt(i) == s.charAt(j)){
                    // case 1 and case 2 and case 3
                    if(i-j <=1 || dp[i-1][j+1]){
                        dp[i][j] = true;
                        if(end - start < i-j){
                            start = j ;
                            end = i;
                        }
                    } else{
                        // character matches but in between not a palindrome.
                        dp[i][j] = false;
                    }
                } else{
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(start ,end+1);
    }
}