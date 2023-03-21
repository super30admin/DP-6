class Solution {

    //Approach 3
    //Time Complexity: O(n*n)
    //Space Complexity: O(1)

    int start = 0;
    int end = 0;

    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0) return null;            //check for null case

        int n = s.length();                                     //initiate n and assign it to the length of s

        for(int i=0; i<n; i++){                                 //iterate through s

            extendAroundCenter(s, i, i);                        //call the function to check the odd length palindrom thats why we are initiating left and right pointer at the same index

            if(i < n-1 && s.charAt(i) == s.charAt(i+1)){        //check if i < n-1 and if character at i and i+1 is equal, then it's possible to get even length palindrome, so for that check conditions
                extendAroundCenter(s, i, i+1);                  //if its true, then call the function and take the left pointer at i and right pointer at i+1
            }
        }
        return s.substring(start, end + 1);                     //return the substring from start to end
    }

    private void extendAroundCenter(String s, int left, int right){

        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){             //iterate till left and right pointers are in the bounds and character at left and right pointers are the same
            left--;                                             //decrement the left pointer
            right++;                                            //increment the right pointer
        }

        if(end - start < (right-1) -(left+1)){                  //check if the new palindrom is max length than the earlier one
            end = right - 1;                                //if so then, update the end and start value, here we are doing right -1 and left +1, because in the while loop we have gone one step ahead from it's required position
            start = left + 1;
        }
    }




    //Approach 2
    //Time Complexity: O(n*n)
    //Space Complexity: O(n)

    // public String longestPalindrome(String s) {

    //     if(s==null || s.length() == 0) return null;

    //     int n = s.length();

    //     boolean dp[] = new boolean[n];
    //     dp[0] = true;

    //     int start = 0;
    //     int end = 0;

    //     for(int i=1; i<n; i++){
    //         for(int j = 0; j<=i; j++){

    //             if(s.charAt(j) == s.charAt(i)){

    //                 if(i-j <2 || dp[j+1]){

    //                     dp[j] = true;

    //                     if(end - start < i -j){
    //                         end = i;
    //                         start = j;
    //                     }
    //                 }
    //                 else{
    //                     dp[j] = false;
    //                 }
    //             }
    //             else{
    //                 dp[j] = false;
    //             }
    //         }
    //     }
    //     return s.substring(start, end + 1);
    // }




    //Approach 1
    //Time Complexity: O(n*n)
    //Space Complexity: O(n*n)

    // public String longestPalindrome(String s) {

    //     if(s==null || s.length() == 0) return null;                 //check for null case

    //     int n = s.length();                         //take n to the length of s

    //     boolean dp[][] = new boolean[n][n];         //create dp array, here we are storing boolean values thats just store if the we can form palindorm or not
    //     dp[0][0] = true;                               //here first element is equal, thats why dp[0][0] = true
    //     int start = 0;                              //start and end, helps to store the length of maximum palindrom and the position of that palindrome
    //     int end = 0;

    //     for(int i=1; i<n; i++){                     //iterate through length of s, here we are taking i=1, because we already take the 1st character and set it true in dp
    //         for(int j=0; j<=i; j++){                //iterate from 0 to i

    //             if(s.charAt(j) == s.charAt(i)){         //check if character at i and j are equal

    //                 if(i-j <2 || dp[i-1][j+1]){         //if yes, then check if i-j <2 means between i and j pointer they have at least one character in between, otherwise they'll cross each other, and also check if dp[i-1][j+1] is true or not, which means that character at i and j are same so inorder to be palindrom character at i-1 and j+1 would be the same as well, so if both condition are true then it means that we can form palindrom from j to i

    //                     dp[i][j] = true;                //mark that as a true
    //                     if(end - start < i-j){          //check the length of current palindrom is maximum than the earlier one
    //                         end = i;                    //if yes, then update the start and end pointer
    //                         start = j;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return s.substring(start, end+1);               //return the substring from start to end
    // }
}



public class LongestPalindromicSubstringLC5 {
}
