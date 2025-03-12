class Solution {
    public int maximumCount(int[] nums) {
        int pos=helper(nums,1);
        int neg=helper(nums,0);
        return Math.max(nums.length-pos,neg);
    }
    private int helper(int nums[],int target){
        int start=0;
        int end=nums.length-1;
        int res=nums.length;
        while(start<=end){
            int mid=(start+end)/2;
            
            if(nums[mid]<target){
                start=mid+1;
            }
            else{
                res=mid;
                end=mid-1;
            }
        }
        return res;
    }
}