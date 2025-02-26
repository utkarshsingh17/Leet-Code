class Solution {
    public int maxAbsoluteSum(int[] nums) {
        if(nums.length==1)return Math.abs(nums[0]);
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>=0){
                max=Math.max(max,sum);
            }
            if(sum<0){
                sum=0;
            }
        }
        sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum<=0){
                min=Math.min(min,sum);
            }
            if(sum>0){
                sum=0;
            }
        }
        return Math.max(Math.abs(max),Math.abs(min));
    }
}