// Time Complexity: O(n)
// Space Complexity: O(n)
// Did the code run successfully? Yes

//Approach: 
// 1. Create an array to store the ugly numbers
// 2. Initialize the first ugly number as 1
// 3. Use three pointers to keep track of the next multiples of 2, 3, and 5
// 4. For each ugly number, calculate the next ugly number as the minimum of the next multiples of 2, 3, and 5
// 5. Update the pointers accordingly

class Solution {
    public:
        int nthUglyNumber(int n) {
            vector<int> ugly(n);
            ugly[0] = 1;
            int p2 = 0, p3 = 0, p5 = 0;
            for(int i = 1; i < n; i++){
                int next = min({ugly[p2] * 2, ugly[p3] * 3, ugly[p5] * 5});
                ugly[i] = next;
                if(next == ugly[p2] * 2){p2++;}
                if(next == ugly[p3] *3){p3++;}
                if(next == ugly[p5] * 5){p5++;}
            }
            return ugly[n - 1];
        }
    };