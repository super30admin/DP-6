class Solution {
    public int nthUglyNumber(int n) {

        List<Integer> nums = new ArrayList();

        nums.add(1);

        int i2 = 0, i3 = 0, i5 = 0;

        for(int i = 1; i < n ; i++){

            int min = Math.min(
                nums.get(i2) * 2, Math.min(nums.get(i3) * 3, nums.get(i5) * 5)
            );

            nums.add(min);

            if(min == nums.get(i2) * 2){
                i2 += 1;
            }
            if(min == nums.get(i3) * 3){
                i3 += 1;
            }
            if(min == nums.get(i5) * 5){
                i5 += 1;
            }
            

        }

        return nums.get(n-1);
        
    }
}

// T(C) : O(n)

// S(C) : O(1)
