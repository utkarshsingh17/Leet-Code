class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if((nums[i]%2==0&&nums[i+1]%2==0)||(nums[i]%2==1&&nums[i+1]%2==1))return false;
        }
        return true;
    }
}