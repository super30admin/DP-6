'''
Time Complexity: 0(nlogk) where k is the elements inside the min-heap
Space Complexity: 0(k)
Run on LeetCode: Yes
'''
import heapq
class Solution:
    
    def __init__(self):
        self.__minHeap = [1]
        self.__setList = set()
    
    def nthUglyNumber(self, n: int) -> int:
        
        # using heapify to convert list into heap
        heapq.heapify(self.__minHeap)
        
        # iterate till count breeches n
        count = 1
        while count < n:
            ele = heapq.heappop(self.__minHeap)
            
            # chk if element is not in set
            if ele not in self.__setList:
                self.__setList.add(ele)
            
            # multiple with 2
            if ele*2 not in self.__setList:
                self.__setList.add(ele*2)
                heapq.heappush(self.__minHeap,ele*2)
            
            # multiple with 3
            if ele*3 not in self.__setList:
                self.__setList.add(ele*3)
                heapq.heappush(self.__minHeap,ele*3)
            
            # multiple with 5
            if ele*5 not in self.__setList:
                self.__setList.add(ele*5)
                heapq.heappush(self.__minHeap,ele*5)
            
            # update count
            count += 1
        '''end of while loop'''
        
        # print('nth value is:\t',self.__minHeap[0])
        return self.__minHeap[0]
            
            
        