//****172.5.Longest Palindromic Substring****
//Time complexity: o(n) square
//Space complexity: 0(1);
//Leetcode runnable - y;
//Any doubts:No;

class Solution {
    int start;
    int end;
    public String longestPalindrome(String s) {
    
        //Null case
        if(s.length()==0) return s;
        
        for(int i=0;i<s.length();i++)
        {
            //for odd
            extendstring(s, i, i);
            //for even
            if(i<s.length()-1 && s.charAt(i)==s.charAt(i+1))
            {
                extendstring(s, i, i+1);
            }
            
        }
        return s.substring(start, end+1);
    }
    
    private void extendstring(String s, int left, int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        
        if(end-start<(right-1)-(left+1))
        {
            start=left+1;
            end=right-1;
        }
    }
}

//****New Ugly Number****
//Time Complexity:0(nlogn)
//Explanation: we are going through all n numbers so, o(n) but as well using priority queue, hence 0(nlogn);
//Space Complexity:o(n)
//Leetcode runnable : Y;
//Any doubts: N;

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        HashSet<Long> set=new HashSet<>();
        long curr=(long)1;
        pq.add(curr);
        set.add(curr);
        int count=0;
        int [] primes=new int[] {2,3,5};
        
        while(count<n);
        {
            curr=pq.poll();
            count++;
            
            for(int prime: primes)
            {
                long newugly= prime*curr;
                if(!set.contains(newugly))
                {
                    pq.add(newugly);
                    set.add(newugly);
                }
            }
            
        }
        return (int)curr;
    }
}

////****New Ugly Number****
//Time Complexity:0(n)
//Explanation: 
//Space Complexity:o(1);
//Leetcode runnable : Y;
//Any doubts: N;

class Solution {
    public int nthUglyNumber(int n) {
        if(n==1)
        {
            return n;
        }
        //Array for storing elements
        int[] arr=new int[n];
        //By default
        arr[0]=1;
        int idx=1;
        //Three Pointers
        int p2=0;
        int p3=0;
        int p5=0;
        //Three Numbers
        int n2=2;
        int n3=3;
        int n5=5;
        
       while(idx<n)
       {
           int min=Math.min(n2, Math.min(n3,n5));
           arr[idx]=min;
           idx++;
           if(min==n2)
           {
               p2++;
               n2=2*arr[p2];
           }
           if(min==n3)
           {
               p3++;
               n3=3*arr[p3];
           }
           
           if(min==n5)
           {
               p5++;
               n5=5*arr[p5];
           }
       }
        return arr[n-1];
        
        
    }
}
