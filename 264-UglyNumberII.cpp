/* 
    Time Complexity                              :  O(N)
    Space Complexity                             :  O(N)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    int nthUglyNumber(int n) {
        if(n == 1) return 1;
        
        int p2=0, p3=0, p5=0;
        vector<int> ans(n);
        ans[0]=1;
        int i=1;
        
        while(i<n) {
            
            int m2 = 2*ans[p2];
            int m3 = 3*ans[p3];
            int m5 = 5*ans[p5];
            
            int mn = min(m2, min(m3,m5));
            ans[i] = mn;
            
            if(m2 == mn)
                p2++;
            if(m3 == mn)
                p3++;
            if(m5 == mn)
                p5++;
            
            i++;
        }
        
        return ans[n-1];
    }
};