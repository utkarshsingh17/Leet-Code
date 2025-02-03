class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int res=1;
        
        int ci=1,cd=1,n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                ci++;
                res=Math.max(res,ci);
                cd=1;
            }else if(nums[i]>nums[i+1]){
                cd++;
                res=Math.max(res,cd);
                ci=1;

            }else{
                ci=1;
                cd=1;
                
            }
        }

        return res;
        
    }
}