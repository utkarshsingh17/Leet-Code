class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int cache[][]=new int[arr.length][arr.length];
        for(int[] c:cache){
            Arrays.fill(c,2);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int res=0;
        for(int j=1;j<arr.length;j++){
            for(int k=j+1;k<arr.length;k++){
                int t=arr[k]-arr[j];
                if(map.containsKey(t) && map.get(t)<j){
                    int i=map.get(t);
                    cache[j][k]=cache[i][j]+1;
                }
                res=Math.max(res,cache[j][k]);

            }
        }
        return res>=3?res:0;
    }
}