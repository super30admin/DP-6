class UglyNumbersii {
    public int nthUglyNumber(int n) {
        if(n == 0) {
            return 1;
        }

        int[] nums = new int[n];
        nums[0] = 1;
        int p2=0, p3=0, p5=0;
        int n2=2, n3=3, n5=5; // 1*2, 1*3, 1*5

        for(int i=1; i<n; i++){
            nums[i] = Math.min(n2, Math.min(n3,n5));
            if(nums[i] == n2){
                p2++;
                n2 = nums[p2] * 2;
            }
            if(nums[i] == n3){
                p3++;
                n3 = nums[p3] * 3;
            }
            if(nums[i] == n5){
                p5++;
                n5 = nums[p5] * 5;
            }
        }
        return nums[n-1];
    }
}
