// TC: O(n)
// SC: O(n)

class LC264 {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int arr[] = new int[n];
        arr[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        int n1 = 2, n2 = 3, n3 = 5;
        for(int i=1;i<n;i++){
            arr[i] = Math.min(n1, Math.min(n2, n3));
            if(arr[i]==n1) n1 = 2*arr[++p1];
            if(arr[i]==n2) n2 = 3*arr[++p2];
            if(arr[i]==n3) n3 = 5*arr[++p3];
        }
        return arr[n-1];
    }
}