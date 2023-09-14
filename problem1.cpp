#include<iostream>
#include<unordered_set>

using namespace std;

class Solution {
public:
    void display(vector<int>& arr){
        for(int c:arr) cout<<c<<" ";
    }
    int nthUglyNumber(int n) {
        if(n==1) return 1;
        vector<int> arr(n,0);
        arr.at(0) = 1;
        int i2{0},i3{0},i5{0};
        unordered_set<int> hash_set{};
        for(int i{1};i<n;){
            int curr_ugly = min(arr.at(i2)*2,min(arr.at(i3)*3,arr.at(i5)*5));
            if(curr_ugly == arr.at(i2)*2){
                i2++;
            }
            else if(curr_ugly == arr.at(i3)*3){
                i3++;
            }
            else if(curr_ugly == arr.at(i5)*5){
                i5++;
            }
            if(hash_set.find(curr_ugly)==hash_set.end()){
                hash_set.insert(curr_ugly);
                arr.at(i) = curr_ugly;
                i++;
            }
        }
        //display(arr);
        return arr.at(n-1);
    }
};