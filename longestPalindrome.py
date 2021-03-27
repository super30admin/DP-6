class Solution:
    def longestPalindrome(self, s: str) -> str:
        # O(n^2)
        # O(1)
        if(len(s)<=1):
            return s
        def countCommon(a,b):
            c = 0
            while(a>=0 and b<len(s) and s[a]==s[b]):
                a-=1
                b+=1
                c+=2
            return c
        o = deque()
        for i in range(1,len(s)):
            x1 = countCommon(i-1,i+1) + 1 #3
            x2 = countCommon(i-1,i) # 0
            x = max(x1,x2) # 3
            if(len(o)<x):
                z = deque([])
                if(x1>=x2):
                    z.append(s[i])
                    x -= 1
                    j=1
                    while(x>0):
                        z.append(s[i+j])
                        z.appendleft(s[i-j])
                        x-=2
                        j+=1
                else:
                    j = 0
                    while(x>0):
                        z.append(s[i+j])
                        z.appendleft(s[i-1-j])
                        x-=2
                        j+=1
                o = z
        return "".join(o)
