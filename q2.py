# Time Complexity : O(n*n), Where n is number of elements in string s
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

import sys

class Solution:
    def __init__(self):
        self.result=-sys.maxsize-1
    
    def expanding(self,start,end,string):
        while(start>=0 and end<len(string) and string[start]==string[end]):
            start-=1
            end+=1
        #Now we should get back to the previous points 
        start+=1
        end-=1
        if(self.result<(end-start+1)):
            self.result=end-start+1
            self.st=start
            self.en=end
        
    def longestPalindrome(self, s: str) -> str:
        n=len(s)
        for i in range(n):
            self.expanding(i,i,s)
            if(i+1<n and s[i]==s[i+1]):
                self.expanding(i,i+1,s)
        
        return s[self.st:self.en+1]