class Solution {
    //DP solution
    //TC: O(n^2)
    //SC: O(1)
    //On LeetCode: Yes
    int min;
    int max;
    int size;
    public String longestPalindrome(String s) {
        min = 0;
        max = 0;
        size = 0;
        if(s == null || s.length() <= 1){
            return s;
        }
        int n = s.length();
        for(int i = 0; i < n; i++){
            checkPalidrome(s,i, i);
            if(i < n - 1){
                checkPalidrome(s, i, i+1);
            }
        }
        return s.substring(min, max +1);
    }
    private void checkPalidrome(String s, int i, int j){
        if(s.charAt(i) != s.charAt(j)){
            return;
        }
        while(i >= 0 && j <= s.length() - 1 && s.charAt(i) ==s.charAt(j)){
            i--;
            j++;
        }
        i++;
        j--;
        if(size < j-i + 1){
            size = j -i + 1;
            min = i;
            max = j;
        }
    }
}