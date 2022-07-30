#Time complexity: O(n^2)
#Space compelxity: O(1)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        max_start,max_end=0,0
        for i in range(len(s)):
            mid=i
            even_start,even_end=self.palindrome(s,mid,mid+1)
            odd_start,odd_end=self.palindrome(s,mid-1,mid+1)
            if((even_end-even_start-1) < (odd_end-odd_start-1)):
                start=odd_start
                end=odd_end
            else:
                start=even_start
                end=even_end
            if(end-start-1>max_end-max_start-1):
                max_start=start
                max_end=end
        return s[max_start+1:max_end]
    def palindrome(self,s,left,right):
        while(left>=0 and right<len(s) and s[left]==s[right]):
            left-=1
            right+=1
        return [left,right]
        
            
            
                
        