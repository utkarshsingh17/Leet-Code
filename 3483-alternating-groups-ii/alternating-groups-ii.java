class Solution {
    public int numberOfAlternatingGroups(int[] input, int k) {
        int i=0,j=1,count=0;
        int[] colors=new int[input.length+k-1];
        for(int l=0;l<colors.length;l++){
            if(l>=input.length){
                colors[l]=input[l%input.length];
            }
            else{
                colors[l]=input[l];
            }
        }
       while(j<colors.length){
            
            if(colors[j]==colors[j-1]){
               i=j;
               j++;
               continue;

            }
            if(j-i+1==k){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}