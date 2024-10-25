def longestPalindrome(self, s: str) -> str:
        # time complexity =O(n^2)
        # space complexity = O(n)
        n = len(s)
        self.start = 0
        self.end = 0
        for i in range(n):
            l = i-1
            r = i+1
            # catch odd
            self.extendAround(s,i,i)
            # catch even
            if i< n-1 and s[i] == s[i+1]:
                self.extendAround(s,i,i+1)
        return s[self.start:self.end+1]

def extendAround(self,s,l,r):
    # if left and right are equal and either are not the end elements decrement l and increment r
    while l>= 0 and r<len(s) and s[l] == s[r]:
        l-=1
        r+=1
    l+=1
    r-=1
    
    if r-l > self.end-self.start:
        self.start = l
        self.end = r
