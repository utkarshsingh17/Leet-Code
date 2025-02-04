class Solution {
    public int maxAscendingSum(int[] nums) {
        int res=nums[0];
        int cur=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                cur+=nums[i];
                res=Math.max(cur,res);
            }else{
                cur=nums[i];
            }
        }
        return res;
    }
}