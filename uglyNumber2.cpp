/*
//Time: O(n)
//Space:O(n) Space consumed by the priority queue and hashSet
class myCompare{
public:
    bool operator()(long a ,long b){
        return a > b;
    }
};
class Solution {
public:
    int nthUglyNumber(int n) {
        set<long> hSet;
        priority_queue<long,vector<long>,myCompare> pq; //min-heap
        hSet.insert(1);
        pq.push(1);
        vector<int> primes = {2,3,5};
        int i = 0;
        long curr =0;
        while(i < n){
            curr= pq.top();
            pq.pop();
            for(int i = 0;i < 3;i++){
                long num = curr*primes[i];
                if(!hSet.count(num)){
                    hSet.insert(num);
                    pq.push(num);
                }
            }
            i++;
        }
        return (int)curr;
    }
};
*/
//Time:O(n)
//Space:O(1)
class Solution {
public:
    int nthUglyNumber(int n) {
        vector<int> ans(n);
        ans[0] = 1;
        int n2 = 2,n3 = 3,n5 = 5;
        int p5 = 0,p2 = 0,p3 =0;
        for(int i = 1; i < n; i++){
            int minVal = min(n2,min(n3,n5));
            ans[i] = minVal;
            if(n2 == minVal){
                p2++;
                n2= 2 * ans[p2];
            }
            if(n3 == minVal){
                p3++;
                n3=3 * ans[p3];
            }
            if(n5 == minVal){
                p5++;
                n5=5 * ans[p5];
            }
        }
        return ans[n-1];
    }
};