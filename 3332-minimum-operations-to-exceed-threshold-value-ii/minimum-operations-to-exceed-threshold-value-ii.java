class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add((long)nums[i]);
        }
        int op=0;
        while(pq.peek()<k&& pq.size()>=2){
            Long x=pq.poll();
            Long y=pq.poll();
            Long z=Math.min(x,y)*2+Math.max(x,y);
            pq.add(z);
            op++;
        }
        return op;
    }
}