Approach 1: 
using the logic of selecting a character and expanding the horizon to get the longest palindromic substring.


// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we see two conditions in this.
1) for every character we see if the window can be extended or not.If yes we extend the window and calculate the start index and maximum length.
2) For every two characters we see if the window can be extended or not.If yes we extend the window and calculate the start index and maximum length.

From the start index and max length we get the longest palindromic substring.

# Time complexity --> o(n**2)
# space complexity --> o(1)
class Solution(object):
    def __init__(self):
        self.maxlen=0
        self.start=0
    def even_odd(self,s,start,end):
        left=start
        right=end
        #for the start and end indices that we get we check if the window can be extended to get the longest palindromic substring or not.
        while left>=0 and right<len(s) and s[left]==s[right]:
            left=left-1
            right=right+1
        #incrementing left and right to get the correct left and right indicies.
        left=left+1
        right=right-1
        #we check if the left and right were able to get the longest palindromic substring or not.if yes we store it the start and maxlen.
        if self.maxlen<right-left+1:
            self.maxlen=right-left+1
            self.start=left
            
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        for i in range(len(s)):
            #sending every character to the even_odd function to check if the left and right side pointers can be incremented to get the longest palindromic substring
            self.even_odd(s,i,i)
            #sending every two characters to the even_odd function to check if the left and right side pointers can be incremented to get the longest palindromic substring
            self.even_odd(s,i,i+1)
        # print(self.start,self.maxlen)
        return (s[self.start:self.start+self.maxlen])
    
 Approach 2: Using DP.
 // Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this problem we start single characeter to the whole string.
1)All the single characters are palindromic so we fill the diagonal elements with true.
2)Next we do for len=2 characters.we check if the next element is same as the current element or not.If yes true else false.
3)we start for len>3 in this if we check the string if it is palindromic from i+1 to j-1 ot not.If yes we check the characters at i and j .If both the conditions satisfy then we make it as true.

In the abve steps we store the start and end pointers to give the longest palindromic string.
 
 # Time complexity --> o(n**2)
# space complexity --> o(n**2)
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s==None or len(s)==0:
            return s
        
        result=[[None for i in range(len(s))]for j in range(len(s))]
        # len=1 for len=1 means for every charcter in the string we fill it in the matrix.as each character is palindromic it is true
        for i in range(len(s)):
            result[i][i]=True
            start=i
            end=i
        # len=2
        #for len=2 we check if the current character is equal to the next character or not.If yes true else false
        for i in range(len(s)-1):
            if s[i]==s[i+1]:
                result[i][i+1]=True
                start=i
                end=i+1
            else:
                result[i][i+1]=False
                
        #Now we fill the matrix for len>3 we check if the string from i+1 to j-1 is palindromic or not and then we check if the characters at index i and j are same or not.If yes then we make it true else false.
        for len1 in range(3,len(s)+1):
            for i in range(len(s)-len1+1):
                j=len1+i-1
                if result[i+1][j-1]==True and s[i]==s[j]:
                    result[i][j]=True
                    start=i
                    end=j
                else:
                    result[i][j]=False
        # print(result)
        return s[start:end+1]
        
        