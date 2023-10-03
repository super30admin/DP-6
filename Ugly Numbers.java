// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will maintain an array for storing all the computed ugly numbers, and a pointer for each ugly 
// number i.e 2,3 and 5 in the array. We will multiply t 2,3 and 5 with the the values in their pointers, 
// find the minimum amongst them and add it to the array. We will move the pointer of the number which gives 
// out the minimum value amongst the 3. 

class Solution {
    public int nthUglyNumber(int n) {
        int[] arr=new int[n];
        arr[0]=1;
        int p2=0,p3=0,p5=0;
        int n2=2,n3=3,n5=5;
        
        for(int i=1;i<n;i++)
        {
            int min=Math.min(n2,Math.min(n3,n5));
            arr[i]=min;
            if(n2==min)
            {
                p2++;
                n2=2*arr[p2];
            }
            if(n3==min)
            {
                p3++;
                n3=3*arr[p3];
            }
            if(n5==min)
            {
                p5++;
                n5=5*arr[p5];
            }
        }
        return arr[n-1];
    }
}