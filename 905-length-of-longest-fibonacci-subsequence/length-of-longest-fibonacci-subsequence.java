class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int len=0,res=0;
        for(int j=1;j<arr.length;j++){
            for(int k=j+1;k<arr.length;k++){
                len=solve(j,k,arr,map);
                if(len>=3){
                    res=Math.max(res,len);
                }
            }
        }
        return res;
    }
    private static int solve(int j, int k, int[] arr, Map<Integer,Integer> map){
        int t=arr[k]-arr[j];
        if(map.containsKey(t)&&map.get(t)<j){
            return solve(map.get(t),j,arr,map)+1;
        }
        return 2;
    }
}