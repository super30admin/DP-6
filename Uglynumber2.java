// space O(n)
//time O(n)

class Solution {
    public int nthUglyNumber(int n) {
        int nums[] = new int [n];
        nums[0]=1;
        int idx2= 0 , idx3=0, idx5=0;
        for(int i =1;i<n;i++)
        {
             int n2= nums[idx2]*2;
             int n3 = nums[idx3]*3;
             int n5 =nums[idx5]*5;
            nums[i] =Math.min(Math.min(n2,n3),n5);
            if(nums[i]==n2)
                idx2++;
            if(nums[i]==n3)
                idx3++;
            if(nums[i]==n5)
                idx5++;
          
        }
        return nums[n-1];
    }
}