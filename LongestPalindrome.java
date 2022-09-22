class Solution {
    String ans="";
    public String longestPalindrome(String s) {
      for( int i=0;i<s.length();i++){
          //centered 
          
          int left=i-1;
          int right=i+1;
          String build=s.charAt(i)+"";
          while(left>=0 && right<s.length()){
              
              if(s.charAt(left)==s.charAt(right)){
              
                  build= s.charAt(left)+build+s.charAt(right);
              
              }else{
                  break;
              }
              left--; right++;
          }
          if(ans.length()<build.length()){ans= new String(build);}
        //  System.out.println(build);
         left=i-1;
         right=i+1;
         build="";
          //check left
          if(left>=0 && s.charAt(left)==s.charAt(i)){
              right=i;

               while(left>=0 && right<s.length()){
              
              if(s.charAt(left)==s.charAt(right)){
              
                  build= s.charAt(left)+build+s.charAt(right);
              
              }else{
                  break;
              }
             left--; right++;  
          }
          if(ans.length()<build.length()){ans= new String(build);}
              
              
              
              
          }
          
         left=i-1;
         right=i+1;
         build="";
          
          //check right
          
          if(right<s.length()&&s.charAt(right)==s.charAt(i)){
              left=i;
               while(left>=0 && right<s.length()){
              
              if(s.charAt(left)==s.charAt(right)){
              
                  build= s.charAt(left)+build+s.charAt(right);
              
              }else{
                  break;
              }
               left--; right++;
          }
          if(ans.length()<build.length()){ans= new String(build);}
              
              
          }
         
          
          
      }  
        return ans;
    }
}
