// Time Complexity: O(N^2)
// Space Complexity: O(1)

class Solution {
    
    int start = 0;
    int maxLen = 0;

    public String longestPalindrome(String s) {
       if(s == null || s.length() < 2) {
       	  return s;
       }

       for(int center = 0; center < s.length(); center++) {
       	   expandAroundCenter(s, center, center);
       	   expandAroundCenter(s, center, center+1);
       }

       return s.substring(start, start + maxLen);

    }

    private void expandAroundCenter(String s, int i, int j) {
    	int left = i, right = j;

    	while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    		left--;
    		right++;
    	}

    	left++;
    	right--;

    	if(maxLen < right - left + 1) {
    		maxLen = right - left + 1;
    		start = left;
    	}
    }
}