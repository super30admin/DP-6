// Time Complexity : will update after class
// Space Complexity :  
// Did this code successfully run on Leetcode : TLE, 291/596 passed

// Your code here along with comments explaining your approach
// keep a counter for number going from 2->infinity, if that is an ugly number, when counter reaches n return num
// find if num is ugly by finding all prime factors, find all and add 2,3,5 to set, if set length is still 3 then ugly
// can memorize previously computed prime factor results

class Solution {
    public int nthUglyNumber(int n) {
        if(n==1)
            return 1;
        
        int num = 2;
        int counter = 1;
        while(counter<n && num<Integer.MAX_VALUE){
            if(isUglyNumber(num)){
                counter++;
            }
            if(counter==n){
                return num;
            }
            
            num++;
        }
        
        return -1;
    }
    
    private boolean isUglyNumber(int num){
        Set<Integer> primeFactors = getPrimeFactors(num);
        Set<Integer> expectedPrimeFactors = new HashSet<>(){
            {
                add(2);
                add(3);
                add(5);
            }
        };
        
        primeFactors.addAll(expectedPrimeFactors);
        
        if(primeFactors.size()==3){
            return true;
        }
        
        return false;
    }
    
    Map<Integer, Set<Integer>> memo = new HashMap<>();
    
    private Set<Integer> getPrimeFactors(int num){
        Set<Integer> primeFactors = new HashSet<>();
        
        if(num%2==0){
            primeFactors.add(2);
            while(num%2==0){
                num /= 2;
                
                if(memo.containsKey(num)){
                    primeFactors.addAll(memo.get(num));
                    return primeFactors;
                }
            }            
        }
        
        
        int upperBound = (int) Math.sqrt(num);  
        
        for(int i=3; i<=upperBound; i+=2){
            if(num%i==0){
                primeFactors.add(i);
                
                num /= i;
                while(num%i==0){
                    num /= i;
                    
                    if(memo.containsKey(num)){
                        primeFactors.addAll(memo.get(num));
                        return primeFactors;
                    }
                }
            }    
        }
        
        if(num>2)
            primeFactors.add(num);
        
        return primeFactors;
    }
}