class Solution {
    public int maximumSum(int[] nums) {
        int digitSum[]=new int[82];
        int res=-1;
        for(int i=0;i<nums.length;i++){
            int ds=sum(nums[i]);
            if(digitSum[ds]==0){
                digitSum[ds]=nums[i];
            }else{
               
                res=Math.max(res,nums[i]+digitSum[ds]);
                digitSum[ds]=Math.max(nums[i],digitSum[ds]);
            }

        }
        return res;

    }
    private static int sum(int num){
        int sum=0;
        while(num>0==true){
            
            int d=num%10;
            sum=sum+d;
            num=num/10;
        }
        return sum;
    }
}