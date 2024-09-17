/*First Attempt */ 
/*-------------------------- *------------- Doesn't work. */
class Solution {
    public int nthUglyNumber(int n) {
        
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 3;
        if(n==4) return 4;
        if(n==5) return 5;
       
        int count=5;
        HashSet<Integer> h = new HashSet<Integer>();
        
        h.add(2); h.add(3);h.add(4);h.add(5);
        
        while(count<n)
        {
            HashSet<Integer> h2 = new HashSet<Integer>();
           Integer j = Collections.min(h);
           
           for(int i : h)
            {
                if(h.contains(j*i)) continue;
                    else
                    {
                        if(count<n)
                        {
                            h2.add(j*i); count++;
                        } 
                    }          
            }
            h.remove(j);  
            h.addAll(h2);
            
        }
        
 return Collections.max(h);   
    }



/*--------------------------------------------*/ 
/*Second Attempt -> Works */
/*Time Complexity : O(LogN)
Space Complexity : O(N)
Did it run on LeetCode :Yes
Any problems? : Could not code DP solution.

*/
class Solution {    
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();  // Create a list to add N ugly numbers.
        HashSet<Integer> set = new HashSet<>();  // Create a Hashset to add numbers.
        set.add(1);  // add 1
        
         TreeSet<Integer> treeSet = new TreeSet<Integer>(set); //Convert Hashset to treeset to get sorted numbers.
      
        for(int i=1; i<=n; i++){
            int j = treeSet.iterator().next();
            list.add(j); // add to list
            
           treeSet.add(2 * j); // get only multiples of 2,3,5 .
            treeSet.add(3 * j); 
            treeSet.add(5 * j); 
            
            treeSet.remove(j); // removing the first element from treeset.
        }
        return list.get(n - 1).intValue();
    }
}
