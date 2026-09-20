//problem1
class Solution {
    public int nthUglyNumber(int n) {
        int[] arr=new int[n];
        arr[0]=1;
        int p2=0,p3=0,p5=0;
        int re2=2,re3=3,re5=5;
        for(int i=1;i<n;i++){
            arr[i]=Math.min(re2,Math.min(re3,re5));
            if(arr[i]==re2){
                p2++;
                re2=arr[p2]*2;
            }
            if(arr[i]==re3){
                p3++;
                re3=arr[p3]*3;
            }
            if(arr[i]==re5){
                p5++;
                re5=arr[p5]*5;
            }
        }
        return arr[n-1];
    }
}
//problem2
class Solution {
    int max;
    int start;
    int end;
    public String longestPalindrome(String s) {
        int n=s.length();
        this.max=0;
        start=0;
        end=0;
        for(int i=0;i<n;i++){
            helper(s,i,i);
            if(i<n-1 && s.charAt(i)==s.charAt(i+1)){
                helper(s,i,i+1);
            }
        }
        return s.substring(start,end+1);
    }
    public void helper(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        left++;
        right--;
        if(max<right-left+1){
            max=right-left+1;
            start=left;
            end=right;
        }
    }
}
