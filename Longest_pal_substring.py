#Space:O(n^2)
#Time:O(n^2)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        dp_matrix = [[False for _ in range(len(s))] for _ in range(len(s))]
        start = 0
        end   =  0
        n = len(s)
        max_len=0
        max_start,max_end=0,0
        
        while(end<n):
            while(start<=end):
                # print(start,end)
                if start==end:
                    dp_matrix[start][end]=True
                    if end-start+1>max_len:
                        max_start,max_end=start,end
                        max_len = end-start+1
                else:
                    # print("if len>1",start,end)
                    if s[start]!=s[end]:
                        dp_matrix[start][end]=False
                    else:
                        if end-start-1<=1:
                            # print("if one or zero character in b/w",start,end)
                            dp_matrix[start][end]=True
                            if end-start+1>max_len:
                                max_start,max_end=start,end
                                max_len = end-start+1
                        else:
                            # print("more than one chare in b/w",s[start:end+1],dp_matrix[start+1][end-1],start+11,end-1)
                            dp_matrix[start][end]=dp_matrix[start+1][end-1]
                            if dp_matrix[start][end]:
                                if end-start+1>max_len:
                                    # print("here",s[start:end+1])
                                    max_start,max_end=start,end
                                    max_len = end-start+1
                # print(s[start:end+1])
                start+=1
            start=0
            end+=1
        # print(s[start:end])
        return s[max_start:max_end+1]
        
        