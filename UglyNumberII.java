// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;
public class UglyNumberII {

        public int nthUglyNumber(int n) {
            TreeSet<Long> tSet = new TreeSet<>();
            tSet.add(1L);
            for (int i=0;i<n-1;i++){
                long temp = tSet.pollFirst();
                tSet.add(temp*2);
                tSet.add(temp*3);
                tSet.add(temp*5);
            }
            return tSet.pollFirst().intValue();
        }
    
}
