"""
Rasika Sasturkar
Time Complexity: O(n)
Space Complexity: O(n)
"""


def nthUglyNumber(n: int) -> int:
    if n == 1:
        return 1

    # Using 3 pointers
    p2, p3, p5 = 0, 0, 0
    n2, n3, n5 = 2, 3, 5

    result = [0 for _ in range(n)]
    result[0] = 1

    for i in range(1, n):
        min_num = min(n2, n3, n5)
        result[i] = min_num
        if n2 == min_num:
            p2 += 1
            n2 = 2 * result[p2]
        if n3 == min_num:
            p3 += 1
            n3 = 3 * result[p3]
        if n5 == min_num:
            p5 += 1
            n5 = 5 * result[p5]

    return result[n - 1]


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(nthUglyNumber(n=10))  # returns 12
    print(nthUglyNumber(n=1))  # returns 1


if __name__ == "__main__":
    main()
