#time-n,space-1
class Solution:
    def __init__(self):
        self.max=0
        self.start=0
        self.end=0
    def longestPalindrome(self, s: str) -> str:
        
       
        for i in range(len(s)-1):
            print(i)
            self.extendaround(s,i,i)#odd length
            if s[i]==s[i+1]:
                print("X")
                self.extendaround(s,i,i+1)
            print(self.start,self.end,"c")
        return s[self.start:self.end+1]
    def extendaround(self,s,i,j):
        
        while (i>=0 and j<len(s)) and s[i]==s[j]:
           
            print("a")
            i=i-1
            j=j+1
        i+=1
        j-=1
        
        if self.end-self.start<j-i:
            self.end=j
            self.start=i
                
           