"""
Pointer Solution :

TC O(N^2) --->for every character in N,  we go left and right till value at those indx not same  O(N)

SC=O(1)

for every char, we will keep it as center of the string and extend it to its left and right to check if its a palindrome.

Odd case -eg babad  left and right same index 
even case -eg babbad -->abba is palindrom. so value at i and i+1 euqal send left as i and right as i+1 to handle even 

when maximum len  becomes equal to string len(), we break.

"""

class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s or len(s) < 2:
            return s
        n = len(s)
        self.maxi1=1
        self.start=0
        for i in range(n):
            self.extendArounIndex(s, i, i)
            if i < n-1 and s[i] == s[i+1]:
                self.extendArounIndex(s, i, i+1)
            if self.maxi1 == n:
                break
        return s[self.start:self.start+self.maxi1]

    def extendArounIndex(self, s, left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        if right-left-1 > self.maxi1:
            self.maxi1 = right-left-1
            self.start = left+1
        