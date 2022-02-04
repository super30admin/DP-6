/*
Worked on LC = YES
Space complexity : O(N)
Time complexity:O(N^2)

*/

class Solution {
    HashMap<String,String> map ;
    int st;
    int e;
    public String longestPalindrome(String s) {
        map = new HashMap();
        
        
        // return getPallindromic(s);
        char [] c_ar = s.toCharArray();
        for(int i =0;i<c_ar.length;i++) {
            helper(i,i,c_ar);
            helper(i,i+1,c_ar);
        }
        return s.substring(st,e+1);
    }
    
    private void helper(int left, int right, char[] c_ar) {
        
            while(left >= 0 && right < c_ar.length && c_ar[left] == c_ar[right]) {
                left--;
                right++;
                
            }
            left++;
            right--;
            
            if(right-left > (e-st)) {
                st=left;
                e= right;
            }
            
        
    }
   
}


