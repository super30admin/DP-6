
//Time Complexity: O(n)
//Space Complexity: O(n)

//accepted on leetcode:Yes

//We use an array to store the first n ugly numbers and We initialize the first ugly number as 1
//We maintain three pointers p2, p3, and p5 to track the position in the array for multiples of 2, 3, and 5 respectively
//We also maintain the next multiples n2, n3, and n5 for 2, 3, and 5
//In each iteration, we find the minimum of n2, n3, and n5 and add it to the array as the next ugly number
//We then update the corresponding pointer and next multiple for whichever number was chosen

class Solution {
    public int nthUglyNumber(int n) {
        int a[]=new int[n];
        a[0]=1;
        int p2=0,p3=0,p5=0,n2=2,n3=3,n5=5;
        int pr[]=new int[]{2,3,5};
        for(int i=1;i<n;i++){
            a[i]=Math.min(n2,Math.min(n3,n5));
            if(a[i]==n2){
                p2++;
                n2=a[p2]*2;
            }
            if(a[i]==n3){
                p3++;
                n3=a[p3]*3;
            }
            if(a[i]==n5){
                p5++;
                n5=a[p5]*5;
            }
        }
        return a[n-1];
    }
}