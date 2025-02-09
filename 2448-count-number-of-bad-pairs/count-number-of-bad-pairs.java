class Solution {
    public long countBadPairs(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]-i;
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(nums[0],1);
        int numsBeforePair=1;
        long badPairs=0;
        for(int j=1;j<nums.length;j++){
            badPairs+=j-map.getOrDefault(nums[j],0);
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
           
        }
        return badPairs;
    }
}