# leetcode 264
# 3 pointer sol
# space - O(n) dp array
# time - O(ilogn)
# passed in leecode
# algo  : #logic is that we get ugly numbers by multiplying the initially formed numbers with 2 or 3 or 5 , ex [1] -- [1,2,3,5]--- [1,2,3,5,(2*2)4,(2*3)6,(2*5)10,(3*2)--already present so wont be added,(3*3)9,(3*5)15]-----but prob here they are not ordered
# We craete a dp array and keep incrementing the optimal next possible ugly number into it, but to find  the next possible ugly number, we first initialise the dp array with 1, as 1 is the 1s ugly number, we then find min of the possible multiples as shown below with i_1,i_2,i_3 pointers
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        dp = [0 for i in range(n)]
        dp[0] = 1
        i_2, i_3, i_5 = 0, 0, 0
        m2, m3, m5 = 2, 3, 5
        for i in range(1, n):
            dp[i] = min(m2, m3, m5)
            if dp[i] == m2:
                i_2 += 1  # change i_2 value for next iteration
                m2 = 2 * dp[i_2]  # change m2 value for next iteration
            if dp[i] == m3:
                i_3 += 1
                m3 = 3 * dp[i_3]
            if dp[i] == m5:
                i_5 += 1
                m5 = 5 * dp[i_5]
        return dp[n - 1]

