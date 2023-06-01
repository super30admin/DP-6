class Solution:
    # Time O(n**2)
    # Space O(h) length of recursion stack
    def longestPalindrome(self, s: str) -> str:
        global reslen, res
        res = []
        reslen = 0

        def extend(a, b):
            while a >= 0 and b < len(s) and s[a] == s[b]:
                global reslen, res
                # temp = s[a:b+1]
                # print(a,b)
                if (b - a + 1) > reslen:
                    # print(a,b)
                    res = [a, b]
                    reslen = (b - a + 1)
                a -= 1
                b += 1

        if len(s) < 2:
            return s
        for i in range(len(s)):
            # print(i)
            # TO FIND ODD NUMBERED PALINDROMES
            a = i
            b = i
            extend(a, b)

            # SAME CODE, BUT TO FIND EVEN NUMBERED PALINDROMOES
            a = i
            b = i + 1
            extend(a, b)
        # print(reslen)
        return s[res[0]: res[-1] + 1]