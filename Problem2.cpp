//
// Created by shazm on 8/28/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    int nthUglyNumber(int n) {
        int dp[n];
        int i2 = 0; int i3 = 0; int i5 = 0;
        int next_2 = 2;
        int next_3 = 3;
        int next_5 = 5;
        int ugly_num = 1;
        dp[0] = 1;
        for(int x = 1; x<n; x++){
            ugly_num = min(next_2,min(next_3,next_5));
            dp[x] = ugly_num;
            if(ugly_num == next_2){
                i2+=1;
                next_2 = dp[i2]*2;
            }
            if(ugly_num == next_3){
                i3+=1;
                next_3 = dp[i3]*3;
            }
            if(ugly_num == next_5){
                i5+=1;
                next_5 = dp[i5]*5;
            }
        }

        return ugly_num;
    }
};