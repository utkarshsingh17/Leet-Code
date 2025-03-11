class Solution {
    public int minimumRecolors(String blocks, int k) {
      int w=0;
      int b=0;
      int i=0;
      int j=0;
      int ans=Integer.MAX_VALUE;
      while(i<blocks.length()){
        if(blocks.charAt(i)=='W'){
            w++;
        }

        if(i-j+1==k){
            ans=Math.min(w,ans);
            if(blocks.charAt(j)=='W'){
                w--;
            }
            j++;
        }
        
        i++;
      }
      return ans;
    }
}