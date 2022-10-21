# Time complexity : O(n*n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return s
        
        # mark the default pointers of start and end as 0, 0
        self.start, self.end = 0, 0
        n = len(s)
        
        # traverse over the length of the string and call the check function
        for i in range(n):
            
            # check for odd length of string
            self.check(s, i, i)
            
            # if we are in-bound, then also check for the even number of chars
            if i < n - 1:
                self.check(s, i, i+1)
        
        # return the subtring from start till end + 1
        return s[self.start: self.end + 1]
    
    def check(self, s, left, right):
        
        # if we are within the boundary and the characters match then decrement the left and increment the right
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        
        # after the end of while loop, we could out of bounds, so increment the left and decrement the right
        left += 1
        right -= 1
        
        # if the current difference is more than the prev one, then update the index ranges
        if right - left > self.end - self.start:
            self.start = left
            self.end = right
