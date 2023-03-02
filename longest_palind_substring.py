# Time Complexity : O(n^2)
# Space Complexity: O(n)

class Solution:
    start = end = 0

    def longestPalindrome(self, s: str) -> str:
        # if not s:
        #     return s

        # def extend(s, i, left, right):
        #     while left >= 0 and right < len(s) and s[left] == s[right]:
        #         left -= 1
        #         right += 1
        #     if right-left-1 > self.end-self.start+1:
        #         self.start = left + 1
        #         self.end = right - 1
        # for i in range(len(s)):
        #     extend(s, i, i, i)
        #     extend(s, i, i, i+1)
        # return s[self.start:self.end+1]

        dp = [[False for i in range(len(s))] for i in range(len(s))]
        if len(s) == 1:
            return s
        max_str = ''
        for i in range(len(dp)):
            dp[i][i] = True
        for i in range(len(dp)-2, -1, -1):
            for j in range(len(dp[0])):
                if s[i] == s[j]:
                    if j - i < 2:
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i+1][j-1]
                else:
                    dp[i][j] = False
                if dp[i][j] and j-i+1 > len(max_str):
                    max_str = s[i:j+1]
        # for val in dp: print(val)
        return max_str
