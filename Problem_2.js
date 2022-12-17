// Problem2: (https://leetcode.com/problems/longest-palindromic-substring/)

// TC: O(n^2)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


let start, end, max;

var expandAroundCenter = (s, left, right) => {
    let n = s.length;
    while (left >= 0 && right < n && s[left] === s[right]) {
        left--;
        right++;
    }
    left++;
    right--;
    if (right - left + 1 > max) {
        max = right - left + 1;
        start = left;
        end = right;
    }
}
/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
    if (s === null || s.length < 2)
        return s;

    start = 0;
    end = 0;
    max = 0;

    for (let i = 0; i < s.length; i++) {
        expandAroundCenter(s, i, i);
        if (i + 1 < s.length)
            expandAroundCenter(s, i, i + 1);
    }
    return s.slice(start, end + 1);
};