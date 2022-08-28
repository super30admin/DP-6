TC:O(n^2)
SC:O(1)

class Solution {
    int start,end;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i=0;i<n;i++){
            ExtendAroundCentre(s,i,i);//odd length palindrome
            if(i<n-1 && s.charAt(i)==s.charAt(i+1)){
                 ExtendAroundCentre(s,i,i+1);//even length palindrome
            }

        }
        return s.substring(start,end+1);
    }
    private void ExtendAroundCentre(String s,int low,int high){
        while(low >=0 && high<s.length() && s.charAt(low) == s.charAt(high)){

                low--;
                high++;

        }
        low++;
        high--;
        if(high-low > end-start){
             start = low;
             end = high;
        }

    }
} 