//Timecomplexity:- O(n^2).
//space complexity:_ O(1).

class Solution {
    int start=0;
    int end=0;
    public String longestPalindrome(String s) {
       for(int i=0;i<s.length();i++){
           checkpalindrome(s,i,i);//for odd length strings.
           checkpalindrome(s,i,i+1);//checking for even length strings
       }
        return s.substring(start,end+1);
    }
    private void checkpalindrome(String s, int left, int right){
        while(left>=0 && right<s.length()&& s.charAt(left)==s.charAt(right)){
            left--;
            right++; // diverging from center if left and right characters are same.
        }
        left++;
        right--;// getting correct range of palindrome length.
        if(right-left>end-start){
            start=left;
            end=right;// updation of start and end for getting substring.
        }
    }
}