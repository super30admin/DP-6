// Time complexity: O(n log k) - insert to heap is log 10
// Space complexity: O(k + n)

// create new values by multiplying each number with 2,3,5
// Maintain a min heap to store all the values in sorted order
// maintain a set to make sure the numbers are not duplicated

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
            // get the next smallest number from the pq
            result = pq.top();
            pq.pop();
            n--;
            // create the new numbers and add to the pq and set of they are unique
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



// Approach 2

// Time complexity: O(n)
// Space complexity: O(n)

/*
Keep 3 pointers 
Get the minimum from the nums and update the vector 
Increment that pointer
Update the number with the new number created by multiplying the value of that pointer with that prime
*/

class Solution {
public:
    int nthUglyNumber(int n) {
        if(n == 1) return 1;
        
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        
        vector<int> nums (n);
        // start with 1 
        nums[0] = 1;
        
        for(int i = 1; i<n; i++) {
            // get the minimum number since we want it in ascending order
            int minNum = min (n2, min(n3, n5));
            // update the result
            nums[i] = minNum;
            // we need to update all the min values to avoid repitition
            if(n2 == minNum) {
                p2++;
                // create the new number and update it
                n2 = 2 * nums[p2];
            }
            if(n3 == minNum) {
                p3++;
                n3 = 3 * nums[p3];
            }
            if(n5 == minNum) {
                p5++;
                n5 = 5 * nums[p5];
            }
        }
        return nums[n-1];
    }
};