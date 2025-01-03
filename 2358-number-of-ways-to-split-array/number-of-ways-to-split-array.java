class Solution {
    public int waysToSplitArray(int[] nums) {
        int size=nums.length;
        long[] leftPrefix=new long[size];
        long[] rightPrefix=new long[size];
        long sum=0;
        int count=0;
        for(int i=0;i<size;i++){
            sum+=nums[i];
            leftPrefix[i]=sum;
        }
        sum=0;
        for(int i=size-1;i>=0;i--){
            sum+=nums[i];
            rightPrefix[i]=sum;
        }
        for(int i=0;i<size-1;i++){
            if(leftPrefix[i]>=rightPrefix[i+1])
            count++;
        }
        return count;
    }
}