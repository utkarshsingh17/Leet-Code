class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int len=0,res=0;
        int cache[][]=new int[arr.length][arr.length];
        for(int[] c:cache){
            Arrays.fill(c,-1);
        }
        for(int k=arr.length-1;k>0;k--){
            for(int j=k-1;j>0;j--){
                len=solve(j,k,arr,map,cache);
                if(len>=3){
                    res=Math.max(res,len);
                }
            }
        }
        return res;
    }
    private static int solve(int j, int k, int[] arr, Map<Integer,Integer> map,int cache[][]){
        if(cache[j][k]!=-1)return cache[j][k];
        int t=arr[k]-arr[j];
        if(map.containsKey(t)&&map.get(t)<j){
            return cache[j][k]= solve(map.get(t),j,arr,map,cache)+1;
        }
        return cache[j][k]=2;
    }
}