class UglyNumber2 {
    //Time complexity: O(n)
    //Space Complexity: O(n)
    public int nthUglyNumber(int n) {
        int[] uglyNum = new int[n+1];

        int ctr2 = 0;
        int ctr3 = 0;
        int ctr5 = 0;
        uglyNum[0] = 1;

        for(int i =1; i < n; i++){
            int uglyCurr = Math.min(uglyNum[ctr2]*2, Math.min(uglyNum[ctr3]*3, uglyNum[ctr5]*5));
            uglyNum[i] = uglyCurr;

            if(uglyCurr == uglyNum[ctr2]*2)ctr2++;
            if(uglyCurr == uglyNum[ctr3]*3)ctr3++;
            if(uglyCurr == uglyNum[ctr5]*5)ctr5++;
        }
        return uglyNum[n-1];
    }
}
