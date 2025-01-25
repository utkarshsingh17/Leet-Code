class Solution {
    static class Pair implements Comparable<Pair>{
        int value;
        int index;
        Pair(int value,int index){
            this.value=value;
            this.index=index;
        }
       @Override
        public int compareTo(Pair p){
            return this.value-p.value;
        }
        @Override
        public String toString(){
            return value+"::"+index;
        }
    }
    static class IndexComparator implements Comparator<Pair>{
            @Override
            public int compare(Pair first,Pair second){
                return first.index-second.index;
            }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        Pair[] pair=new Pair[n];
        for(int i=0;i<n;i++){
            pair[i]=new Pair(nums[i],i);
        }
        Arrays.sort(pair);
        int left=0,right=1;
        while(right<n){
            List<Integer>pos=new ArrayList<>();
            pos.add(pair[left].index);
            while(right<n&& Math.abs(pair[right].value-pair[right-1].value)<=limit){
                pos.add(pair[right].index);
                right++;
            }
            Collections.sort(pos);
            for(int i=0;i<right-left;i++){
                nums[pos.get(i)]=pair[left+i].value;
            }
            left=right;
            right++;
        }
        return nums;
    }
}