class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n=heightMap.length;
        int m=heightMap[0].length;
        PriorityQueue<int[]>queue=new PriorityQueue<>((a,b)->{
            if(a[0]<b[0])return -1;
            else if(a[0]>b[0])return 1;
            else return 0;
        });
        int[][] visited=new int[n][m];
        for(int i=0;i<n;i++){
            queue.add(new int[]{heightMap[i][0],i,0});
            visited[i][0]=1;
            queue.add(new int[]{heightMap[i][m-1],i,m-1});
            visited[i][m-1]=1;
        }
        for(int i=0;i<m;i++){
             queue.add(new int[]{heightMap[0][i],0,i});
            visited[0][i]=1;
            queue.add(new int[]{heightMap[n-1][i],n-1,i});
            visited[n-1][i]=1;
        }
        int diff[][]={{0,1},{0,-1},{-1,0},{1,0}};
        int level=0;
        int water=0;
        while(queue.isEmpty()==false){
            int[] top=queue.poll();
            level=Math.max(level,top[0]);
            int ht=top[0];
            int row=top[1];
            int col=top[2];
            for(int i=0;i<4;i++){
                int d[]=diff[i];
                int nRow=row+d[0];
                int nCol=col+d[1];
                if(nRow<n&&nCol<m&&nRow>=0&&nCol>=0&&visited[nRow][nCol]==0){
                    if(heightMap[nRow][nCol]<level){
                        water+=level-heightMap[nRow][nCol];
                    }
                        queue.add(new int[]{heightMap[nRow][nCol],nRow,nCol});
                        visited[nRow][nCol]=1;
                    
                }
            }

        }
        return water;
    }
}