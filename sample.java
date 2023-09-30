//Problem 1: Ugly Number 2
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Can be done with pointers and PQ
class Solution {
    public int nthUglyNumber(int n) {
        //NlogN
        // PriorityQueue<Long> q = new PriorityQueue<>();
        // Set<Long> set= new HashSet<>();
        // int[] primes=new int[]{2,3,5};
        // int count=0;
        // long curUglyNum=1l;
        // q.add(curUglyNum);
        // set.add(curUglyNum);

        // while(count!=n){
        //     curUglyNum=q.poll();
        //     count++;
        //     for(int num: primes){
        //         long newUgly= curUglyNum*num;
        //         if(!set.contains(newUgly)){
        //             q.add(newUgly);
        //             set.add(newUgly);
        //         }
        //     }
        // }
        // return (int)curUglyNum;

        //O(n) O(1)
        int[] arr= new int[n];
        arr[0]=1;
        int p2=0, p3=0, p5=0;
        int n2=2, n3=3, n5=5;

        for(int i=1;i<n;i++){
            int min=Math.min(n2, Math.min(n3,n5));
            arr[i]=min;
            if(n2==min){
                p2++;
                n2=2*arr[p2];
            }
            if(n3==min){
                p3++;
                n3=3*arr[p3];
            }
            if(n5==min){
                p5++;
                n5=5*arr[p5];
            }
        }
        return arr[n-1];
    }
}

//Problem 2: Longest Palindrome String
// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Brute: O(n^3)
//Two pointers O(n^2)
//DP O(n^2)
class Solution {
    int start, end;
    public String longestPalindrome(String s) {
        // int max=0;
        // String maxString="";
        // if(Palindrome(s))
        //     return s;
        // else{
        //     for(int i=0;i<s.length()-1;i++){
        //         for(int j=s.length()-1;j>=i;j--){
        //             String a=s.substring(i,j+1);
        //             //System.out.println(a);
        //             if(Palindrome(a)&&max<a.length()){
        //                 max=a.length();
        //                 maxString=a;
        //             }
        //         }
        //     }
        // }
        // return maxString;    

        // String m ="";
        // int longest = 0;
        // for(int i=0;i<s.length();i++){
        //  // odd length
        //     int left =i;
        //     int right = i;
        //     while(left>=0 && right<s.length() && s.charAt(left)== s.charAt(right)){
        //        if(right-left +1 > longest){
        //            longest = right-left+1;
        //            m = s.substring(left,right+1);
        //        }
        //         left--;
        //         right++;
        //     }
        // // even length
        //     left = i;
        //     right = i+1;
        //       while(left>=0 && right<s.length() && s.charAt(left)== s.charAt(right)){
        //        if(right-left +1 > longest){
        //            longest = right-left+1;
        //            m = s.substring(left,right+1);
        //        }
        //         left--;
        //         right++;
        //     }
        // }
        // return m;

        int n=s.length();
        // for(int i=0;i<n;i++){
        //     extendAround(s, i, i);
        //     if(i<n-1 && s.charAt(i)==s.charAt(i+1))
        //         extendAround(s, i, i+1);
        // }
        // return s.substring(start, end+1);

        boolean[] dp= new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(i-j<2 || dp[j+1]){
                       dp[j]=true;
                        if(end-start<i-j){
                            start=j;
                            end=i;
                        } 
                    }else{
                        dp[j]=false;
                    }
                }else{
                    dp[j]=false;
                }
            }
        }

        return s.substring(start, end+1);
    }

    private void extendAround(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        left++;
        right--;
        if(right-left > end-start){
            start=left;
            end=right;
        }
    }

    // public boolean Palindrome(String s){
    //     int j=s.length()-1;
        
    //     for(int i=0;i<j && s.length()!=1;i++,j--){
    //         if(s.charAt(i)!=s.charAt(j))
    //             return false;
    //     }
    //     return true;
    // }
}