//Time - O(n^2)
//Space - O(1)
class Solution {
    int start; int end;
    public String longestPalindrome(String s) {
        for(int i=0; i< s.length(); i++){
            if(i< s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                expandString(s,i,i+1);
            }
                 expandString(s,i,i);
        }
        return s.substring(start,end+1);
    
    }

    void expandString(String s, int i, int j){
        while(i>=0 && j< s.length() && s.charAt(i) == s.charAt(j)){
            i--;j++;
        }
        i++; j--;
        if(j-i > end-start){
            end =j; start =i;
        }
    }
}