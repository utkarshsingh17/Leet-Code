class Solution {
    public int waysToSplitArray(int[] nums) {
        int size=nums.length;
      
        long sum=0;
        int count=0;
        for(int i=0;i<size;i++){
            sum+=nums[i];  
        }
        long leftSum=0;
        for(int i=0;i<size-1;i++){
             leftSum+=nums[i];
            long rightSum=sum-leftSum;
            if(leftSum>=rightSum)count++;

        }
        return count;
    }
}