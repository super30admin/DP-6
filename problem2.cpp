#include<iostream>
#include<string>

using namespace std;

class Solution {
    string get_pal(string& s,int left,int right){
        int sz = s.size();
        while(left>=0 && right< sz && s.at(left) == s.at(right)){
            left --;
            right ++;
        }
        return s.substr(left+1,right-left-1);
    }
public:
    string longestPalindrome(string s) {
        int sz = s.size();
        if(sz == 1) return s;
        string sol{};
        int max_pl{0};
        for(int i{};i<sz;++i){
            //check odd length pal
            string res = get_pal(s,i,i);
            int res_sz = res.size();
            if(res_sz>max_pl){
                max_pl = res_sz;
                sol.assign(res);
            }
            if(i+1<sz && s.at(i) == s.at(i+1)){
                res = get_pal(s,i,i+1);
                res_sz = res.size();
                if(res_sz>max_pl){
                    max_pl = res_sz;
                    sol.assign(res);
                }
            }
        }
        return sol;
    }
};