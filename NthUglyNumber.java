
//TC-O(N)  SC-O(N)
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] uglyNums=new int[n];
        uglyNums[0]=1;
        int idx2=0;
        int idx3=0;
        int idx5=0;
        int nextMul2=2;
        int nextMul3=3;
        int nextMul5=5;

        for(int i=1;i<n;i++){
            int nextUglyNum=Math.min(
                    nextMul2,
                    Math.min(nextMul3,nextMul5)
            );
            uglyNums[i]=nextUglyNum;
            if(nextUglyNum==nextMul2){
                idx2++;
                nextMul2=uglyNums[idx2]*2;
            }
            if(nextUglyNum==nextMul3){
                idx3++;
                nextMul3=uglyNums[idx3]*3;
            }
            if(nextUglyNum==nextMul5){
                idx5++;
                nextMul5=uglyNums[idx5]*5;
            }
        }
        return uglyNums[n-1];
    }

    public static void main(String[] args) {
        NthUglyNumber uglyNumber=new NthUglyNumber();
        System.out.println(uglyNumber.nthUglyNumber(18));
    }
}
