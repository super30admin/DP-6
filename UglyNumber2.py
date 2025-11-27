# Time complexity: O(N) where N is the number of elements that we pop from heap. and space is also O(N) for the using the heap

# To maintain order we have min heap and to get rid of duplicates we use set, the intuition here is to calculate the next ugly numbers from the previous ones generated.

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1: return 1
        count = 0
        hashset = set()
        heap = []
        heapq.heappush(heap, 1)
        hashset.add(1)
        prime = [2,3,5]
        while count != n:
            currNum = heapq.heappop(heap)
            count += 1
            for num in prime:
                newNum = currNum * num
                if newNum not in hashset:
                    heapq.heappush(heap, newNum)
                    hashset.add(newNum)

        return currNum

# Time complexity: O(n) where n in the size of arr. Space is also O(n)
# Here instead of using heap or set, we just use pointers and use that to generate the next immediate ugly number
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        p2,p3,p5 = 0,0,0
        n2,n3,n5 = 2,3,5
        arr = [0] * n
        arr[0] = 1
        for i in range(1, n):
            minVal = min(n2, n3, n5)
            arr[i] = minVal
            if n2 == minVal:
                p2 += 1
                n2 = 2 * arr[p2]
            if n3 == minVal:
                p3 += 1
                n3 = 3 * arr[p3]
            if n5 == minVal:
                p5 += 1
                n5 = 5 * arr[p5]

        return arr[n-1]