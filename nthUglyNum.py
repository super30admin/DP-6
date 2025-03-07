"""
Ugly numbers are formed by multiplying ugly numbers only
TC: O(n)
SP:O(n)
"""
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        pa = pb = pc = 0
        arr = [1]
        for i in range(1, n):
            next_num = min(arr[pa]*2, arr[pb]*3, arr[pc]*5)
            arr.append(next_num)
            if next_num==arr[pa]*2:
                pa+=1
            if next_num==arr[pb]*3:
                pb+=1
            if next_num==arr[pc]*5:
                pc+=1
        return arr[n-1]