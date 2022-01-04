class Solution {
    int max;
    int start;
    int end;
    
    public String longestPalindrome(String s) {
        if(s == null) return s;
        int n = s.length();
        for(int i = 0; i < n; i++){
            extendAtCenter(s, i, i);
            if(i != n -1 && s.charAt(i) == s.charAt(i+1)){
                //even
                extendAtCenter(s, i, i+1);
            }
        }
        return s.substring(start, end+1);
    }
    private void extendAtCenter(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--; r++;
            
        }
        l++; r--;
        
        if(max < r - l + 1){
            max = r - l + 1;
            start = l;
            end = r;
        }
        
    }
}

//TC: O(n)
//SC: O(1)
