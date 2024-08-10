class Solution {
public:
    int nthUglyNumber(int n) {
        set<long long> s;
        s.insert(1);

        for(auto u: s){
            //cout<<u<<endl;
            s.insert(u*2);
            s.insert(u*3);
            s.insert(u*5);

            n--;
            if(n==0)  return u;
        }

        return 3636;
    }
};
