'''
Time Complexity: 0(n*n)
Space Complexity: 0(n*n)
Run on LeetCode: Yes
'''
class Solution:
    
    def __init__(self):
        self.start = None
        self.end = None
    
    def memory2D(self,string):
        
        # initialize memory2D
        memory2D = [[None for col in range(0,len(string))] for row in range(0,len(string))]
        
        # iterate the 2D matrix
        for i in range(0,len(string)):
            for j in range(0,len(string)):
                
                # case -- row is 0
                if i == 0 and j == 0:
                    self.start = j
                    self.end = i
                    memory2D[i][j] = True
                    break
                
                # for other cases
                elif string[j] == string[i] and i-j <= 2:
                    memory2D[i][j] = True
                    
                    if (self.end - self.start) <= (i-j):
                        self.end = i
                        self.start = j
                    
                elif string[j] == string[i] and i-j > 2:
                    memory2D[i][j] = memory2D[i-1][j+1] # digonally-up
                    if memory2D[i][j] == True and (self.end - self.start) <= (i-j):
                        self.end = i
                        self.start = j
                
                # base check 
                if j == i:
                    break
            '''end of col iteration'''
        '''end of row iteration'''
        
        # print('Max subString length is:\t',rtrString)     
        return string[self.start:self.end+1]
    
    def longestPalindrome(self, s: str) -> str:
        return self.memory2D(s)