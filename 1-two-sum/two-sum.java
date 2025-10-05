class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int temp=target-nums[i];
            if(map.containsKey(temp))
                return new int []{map.get(temp),i};
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two solutions");
        
    }
}