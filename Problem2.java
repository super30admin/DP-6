
//Time Complexity: O(n^2)
//Space Complexity: O(1)

//accepted on leetcode:Yes

//for each character in the string, we are trying to extend around it to find the longest palindrome
//To find odd length palindromes, we call extendsAround with the same left and right indices
//To find even length palindromes, we call extendsAround with left as i and right as i+1 if the characters are the same
//In the extendsAround method, we keep expanding the left and right indices as long as the characters at those indices are the same
//Once we can no longer expand, we check if the length of the palindrome found is greater than the current maximum length
//If it is, we update the maximum length and the start and end indices of the palindrome
//After checking all characters, we return the substring from start to end as the longest palindrome found

class Solution {
    int max,start,end;
    public String longestPalindrome(String s) {
        int n=s.length();
        this.max=Integer.MIN_VALUE;
        this.start=0;
        this.end=0;

        for(int i=0;i<n;i++){
            //odd length
            extendsAround(s,i,i);
            //even length
            if(i+1<n&&s.charAt(i)==s.charAt(i+1))
                extendsAround(s,i,i+1);
        }
        return s.substring(start,end+1);
    }
    void extendsAround(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        left++;
        right--;
        if(max<right-left+1){
            max=right-left+1;
            start=left;
            end=right;
        }
    }
}