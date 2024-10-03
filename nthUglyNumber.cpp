// Time complexity: O(n log k)
// Space complexity: O(k + n)
class Comparator {
public:
    bool operator () (long a , long b) {
        if(a>b) return true;
        return false;
    }
};

class Solution {
public:
    int nthUglyNumber(int n) {
        if(n == 0) return 0;

        priority_queue<long, vector<long>, Comparator > pq;
        unordered_set<long> set;
        vector<int> uglyPrimes = {2,3,5};
        long result;
        pq.push(1);
        set.insert(1);
        while(n > 0) {
            result = pq.top();
            pq.pop();
            n--;
            for(int primes: uglyPrimes) {
                long newNum = primes * result;
                if(set.find(newNum) == set.end()) {
                    pq.push(newNum);
                    set.insert(newNum);
                }
            }
        }
        return (long)result;
    }
};



