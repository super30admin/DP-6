import java.util.TreeSet;
// Time O(NLogN)
//Space O(N)


public class UglyNumber2 {
	public int nthUglyNumber(int n) {
		if(n==1) return n;
		    TreeSet<Long> ts = new TreeSet<>();
		       ts.add(1l);
		        long temp=0;
		       for(int i=0;i<n;i++){
		        temp = ts.pollFirst();
		          ts.add(2*temp);
		          ts.add(3*temp);
		          ts.add(5*temp);  
		      }
		       
		       return (int)temp;
		    }
}
