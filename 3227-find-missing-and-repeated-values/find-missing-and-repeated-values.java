class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=grid.length;
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
                sum+=grid[i][j];
            }
        }
        System.out.println(sum);
        int sq=n*n;
        int exp=(int)(sq*(sq+1))/2;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int k=entry.getKey();
            int v=entry.getValue();
            if(v==2){
                System.out.println(k);
               return new int[]{k,(int)(exp)-(sum-k)};
            }
        }
        return new int[]{};
    }
}