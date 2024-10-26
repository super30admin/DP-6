# time : O(n2)
# space: O(1)

class Solution(object):
    def longestPalindrome(self, s):
        if len(s) == 1:
            return s
        maxL = 0
        maxStr = s[0]
        for pivot in range(len(s)):
            l, r = pivot - 1, pivot + 1
            while l >= 0 and r < len(s) and s[l] == s[r]:
                lg = r - l + 1
                if lg > maxL:
                    maxStr = s[l:r+1]
                    maxL = max(lg, maxL)
                l -= 1
                r += 1
            l, r = pivot, pivot + 1
            while l >= 0 and r < len(s) and s[l] == s[r]:
                lg = r - l + 1
                if lg > maxL:
                    maxStr = s[l:r+1]
                    maxL = max(lg, maxL)
                l -= 1
                r += 1
        return maxStr

        