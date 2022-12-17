// Problem1: (https://leetcode.com/problems/ugly-number-ii/)

// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function (n) {
    if (n === 1)
        return 1;
    let result = new Array(n);
    result[0] = 1;
    let p2 = 0, p3 = 0, p5 = 0;
    let n2 = 2, n3 = 3, n5 = 5;
    let count = 0;
    while (count < n) {
        count++;
        let min = Math.min(n2, Math.min(n3, n5));
        result[count] = min;
        if (min === n2) {
            p2++;
            n2 = 2 * result[p2];
        }
        if (min === n3) {
            p3++;
            n3 = 3 * result[p3];
        }
        if (min === n5) {
            p5++;
            n5 = 5 * result[p5];
        }
    }
    return result[n - 1];
};

