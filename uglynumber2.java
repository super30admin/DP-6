/*
Time Complexity: O(N)
Space Complexity: O(N)
*/
public int nthUglyNumber(int n) {
        
    
    int[]dp=new int[n+1];
    dp[1]=1;
    int f1=dp[1];
    int f2=dp[1];
    int f3=dp[1];
    
    for(int i=2;i<=n;i++){
    int two=2*dp[f1];
    int three=3*dp[f2];
    int five=5*dp[f3];
    
    int min=Math.min(two,Math.min(three,five));
    dp[i]=min;
    
    if(min==two){
    f1++;   
    }
    if(min==three){
    f2++;
    }
    
    if(min==five){
    f3++;
    }
    }
    
    return dp[n]; 
    }