//Time - O(n)
//Space - O(1)
class Solution {
public:
    int nthUglyNumber(int n) {
        if(n==1) return 1;
        int a = 0,b = 0,c = 0,u;
        vector<int> k(1,1);
        
        while(k.size()<n){
            u = min(k[a]*2,min(k[b]*3,k[c]*5));
            k.push_back(u);
            if(k.back() == k[a]*2) a++;
            if(k.back() == k[b]*3) b++;
            if(k.back() == k[c]*5) c++;
            
        }
        
        return k.back();
    }
};
