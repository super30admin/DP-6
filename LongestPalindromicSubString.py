# Time complexity: O(n^2).
# Space complexity: O(1)

# The logic here is to determine if a string is a palindrome, expand from the char outwards. Hence, we need two pointers and then anytime the char are same, expand outward
# and check if char is same again, if yes then its a palindrome and capture the length. Hence, we need to do this for odd and even length. For Odd we can start at the same char
# whereas for even we can start with first char and neighbor char.

class Solution:
    def longestPalindrome(self, s: str) -> str:
        maxLength = 0
        maxL = 0
        maxR = 0

        for i in range(len(s)):
            # for odd:
            p1 = i
            p2 = i
            while p1 >= 0 and p2 < len(s):
                if s[p1] == s[p2]:
                    currLength = p2 - p1 + 1
                    if currLength > maxLength:
                        maxLength = currLength
                        maxL = p1
                        maxR = p2
                    p1 -= 1
                    p2 += 1
                else:
                    break
            #even palindrome
            p1 = i
            p2 = i + 1
            while p1 >=0 and p2 < len(s):
                if s[p1] == s[p2]:
                    currLength = p2 - p1 + 1
                    if currLength > maxLength:
                        maxLength = currLength
                        maxL = p1
                        maxR = p2
                    p1 -= 1
                    p2 += 1
                else:
                    break

        return s[maxL: maxR+1]