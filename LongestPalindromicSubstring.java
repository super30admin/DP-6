class Solution {
    int start =0;
    int end =0;
    int max =0;
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++) {
            extend(s,i,i);
            if(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)) {
                extend(s,i,i+1);
            }
        }
        return s.substring(start, end+1);
    }

    public void extend(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        left++;
        right--;

        if(max< right-left+1) {
            max = right-left+1;
            start = left;
            end = right;
        }
    }
}
