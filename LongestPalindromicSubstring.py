"""
Rasika Sasturkar
Time Complexity: O(n^2), n is length of string
Space Complexity: O(1), DP = O(n^2)
"""


def longestPalindrome(s: str) -> str:
    # null case
    if s is None:
        return s

    n = len(s)
    start, end = 0, 0

    # Using DP
    # dp = [False for _ in range(n)]
    # for i in range(n):
    #     for j in range(i + 1):
    #         if s[i] == s[j] and ((i - j < 2) or dp[j + 1]):
    #             dp[j] = True
    #             if i - j > end - start:
    #                 start = j
    #                 end = i
    #         else:
    #             dp[j] = False

    # Using Extend around center
    def extend_around_center(left, right):
        nonlocal start, end
        while left >= 0 and right <= len(s) - 1 and s[left] == s[right]:
            left -= 1
            right += 1
        left += 1
        right -= 1
        if right - left > end - start:
            end = right
            start = left

    for i in range(n):
        extend_around_center(i, i)  # odd case
        if i < n - 1:
            extend_around_center(i, i + 1)  # even case

    return s[start:end + 1]


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(longestPalindrome(s="babad"))  # returns "bab"
    print(longestPalindrome(s="cbbd"))  # returns "bb"


if __name__ == "__main__":
    main()
