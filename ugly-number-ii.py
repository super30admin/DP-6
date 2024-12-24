#Time Complexity: Generating n ugly numbers involves n heap operations, where each heappush and heappop takes O(logn) time in the worst case. Thus, the overall complexity is O(n⋅logn).
#Space Complexity: The heap and hashset grow to store up to n ugly numbers, so the space complexity is O(n).
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        heap = []
        hashset = set()
        prime = [2,3,5]
        currUgly = 1
        heapq.heappush(heap, currUgly)
        hashset.add(currUgly)
        while(n>0):
            n-=1
            currUgly = heapq.heappop(heap)
            for p in prime:
                newUgly = currUgly * p
                if(newUgly not in hashset):
                    hashset.add(newUgly)
                    heapq.heappush(heap, newUgly)
        return int(currUgly)

        
        