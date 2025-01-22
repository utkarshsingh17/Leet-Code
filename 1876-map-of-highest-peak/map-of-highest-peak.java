class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        Queue<int[]> queue=new ArrayDeque<>();
        int visited[][]=new int[m][n];
        for(int i=0;i<isWater.length;i++){
            for(int j=0;j<isWater[0].length;j++){
                if(isWater[i][j]==1){
                    queue.add(new int[]{0,i,j});
                    visited[i][j]=1;
                }
            }
        }
        int diff[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int ans[][]=new int[m][n];
        while(queue.isEmpty()==false){

            int top[]=queue.poll();
            int val=top[0];
            int row=top[1];
            int col=top[2];

            for(int i=0;i<diff.length;i++){
                int dif[]=diff[i];
                int nRow=row+dif[0];
                int nCol=col+dif[1];
                if(nRow<m&&nRow>=0&&nCol<n&&nCol>=0&&visited[nRow][nCol]==0){
                    ans[nRow][nCol]+=val+1;
                    queue.add(new int[]{val+1,nRow,nCol});
                    visited[nRow][nCol]=1;

                }
            }
        }

        return ans;
    }
}