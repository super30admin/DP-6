class Solution:

    #two pointer approach
    def longestPalindrome(self, s: str) -> str:


        self.start ,self.end,self.max = 0,0,0

        for i in range(len(s)):
            if self.max == len(s):
                break
            self.expandstring(s,i,i)
            if i < len(s)-1 and s[i] == s[i+1]:
                self.expandstring(s,i,i+1)

        return s[self.start:self.end+1]


    def expandstring(self,s,left,right):

        while len(s) > left >= 0  and len(s) > right >= 0 and s[left] == s[right]:

            left-=1
            right +=1
        left +=1
        right -=1
        #print(self.max, left, right)
        if self.max < (right - left +1):
            self.max = right - left +1
            self.start = left
            self.end = right