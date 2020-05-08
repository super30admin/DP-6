// TimeComplexity --> Approach 1 O(n^2) //DP 
// TimeComplexity --> Approach 2 O(n^2) // Expand from centre

// SpaceComplexity --> Approach 1 (O(n^2)) Matrix Size
// SpaceComplexity --> Approach 2 (O(1)) No additional space used

class Solution {
    
    int start = 0;
    int maxLen = 0;
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() == 0 || s.length() ==1)
            return s;
        
       /** // There are two approaches to this problem 
        // DP way - Storing isPalindrome for Len 1 and 2 and expand to greater windows ((Time -> O(n^2) Space -> O(n^2)))
        // Expanding inside out, from Centre check if imediate right and left are same, if so proceed further until max palidrom is identified.(Time -> O(n^2) Space -> O(1))
        
        // Approach 1
        int windowSize = 1;
        int n = s.length();
        int startFrom = 0;
        int maxLen = 0;
        boolean[][] isPalindromMatrix = new boolean[n][n];  //Each char in string is row and col
        for(int i = 0; i< n; i++){
            //Single char is always a palindorme so diagonals  will be Palindrome set true.
            isPalindromMatrix[i][i] = true;
        }
        windowSize = 2;
        for(int i = 0; i<n-1; i++){
            //Window of size 2 will be palindrome is both char are equal.
            if(s.charAt(i) == s.charAt(i+1)){
                isPalindromMatrix[i][i+1] = true; 
                startFrom = i;
                maxLen = i+1;
            }else{
                isPalindromMatrix[i][i+1] = false; 
            }  
        } 
        
        // windowSize > 2
        for(windowSize = 3;windowSize<=n; windowSize++){
            
            for(int start = 0; start<n - windowSize + 1; start++){
                // int cursor = i;
                int end = windowSize + start-1; 
                if(s.charAt(start) == s.charAt(end) && isPalindromMatrix[start+1][end-1]){
                    isPalindromMatrix[start][end] = true;
                    maxLen = end;
                    startFrom = start;
                }
                
            }
        }
        // System.out.println(startFrom + " " + (startFrom + maxLen));
        return s.substring(startFrom, maxLen+1 );**/
        
        for(int centre=0; centre<s.length(); centre++){
            expandFromCentre(s,centre, centre);   //Odd window size 
            expandFromCentre(s,centre, centre+1);  // Even Window Size
        }
        return s.substring(start,start+maxLen );
    }
    
    //Approach 2 --> Expand from Centre
    
    private void expandFromCentre(String s, int left, int right){
        
        int n = s.length(); 
        while(left>=0 && right < n && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            
        }
        
       
        left++;          // To address last increment which failed in the while loop
        right--;
        
        if(maxLen < right - left +1){
            start = left;
            maxLen = right - left + 1;
        }
        
        
    }
}






