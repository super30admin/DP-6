//time complexity- O(n^2)
//space complexity- O(1)
public class LongestPalindromicSubstring {
    static int start = 0;
    static int end = 0;
    static public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 1) return s;
        int max = 0;
        String sb = "";

        for(int i =  0 ; i < len; i++) {
            findPaindrome(s, i, i);
            if(i != len-1 && s.charAt(i) == s.charAt(i+1)) {
                findPaindrome(s, i, i+1);
            }
        }

        return s.substring(start, end+1);
    }
    private static void findPaindrome(String s, int st, int e) {
        while(st >= 0 && e < s.length()  && s.charAt(st) == s.charAt(e)) {
            st--;
            e++;
        }
        st++;
        e--;
        if(e - st > end - start) {
            start = st;
            end = e;
        }
    }
    public static void main(String[] args) {
        String s = "blahbababh";
        System.out.println("Longest palindrome in String "+ s + "is: "+ longestPalindrome(s));
    }
}
