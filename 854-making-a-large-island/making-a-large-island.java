class Solution {
    private static int dfs(int[][] grid,boolean[][] visited,int row,int col,int[][]diff,int id,int n){
        if(row<0||col<0||row>=n||col>=n||visited[row][col]==true||grid[row][col]!=1)return 0;
        grid[row][col]=id;
        visited[row][col]=true;
        int size=1;
        for(int dif[]:diff){
            int nr=row+dif[0];
            int nc=col+dif[1];
            size+=dfs(grid,visited,nr,nc,diff,id,n);
        }
        return size;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;

        boolean visited[][]=new boolean[n][n];
        int maxArea=0;
        int id=2;
        Map<Integer,Integer> map=new HashMap<>();
        int diff[][]={{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&visited[i][j]==false){
                   int size= dfs(grid,visited,i,j,diff,id,n);
                    map.put(id,size);
                    id++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    Set<Integer> uniqueIds=new HashSet<>();
                    for(int dif[]:diff){
                        int nr=i+dif[0];
                        int nc=j+dif[1];
                        if(nr>=0&&nc>=0&&nr<n&&nc<n&&grid[nr][nc]!=0){
                            uniqueIds.add(grid[nr][nc]);
                        }
                    }

                    int overAllSize=1;
                    
                   
                    for(int ids:uniqueIds){
                        
                        overAllSize+=map.get(ids);
                    }
                    maxArea=Math.max(maxArea,overAllSize);
                }
            }
        }

        return maxArea==0 ? n*n : maxArea;
    }
}