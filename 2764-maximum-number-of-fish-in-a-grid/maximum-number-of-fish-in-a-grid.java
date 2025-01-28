class Solution {
    static class Node{
        private int row;
        private int col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
        public int getRow(){
            return this.row;
        }
        public int  getCol(){
            return this.col;
        }
        public void setCol(int col){
            this.col=col;
        }
        public void setRow(int row){
            this.row=row;
        }
        @Override
        public String toString(){
            return "Node::["+row+","+col+"]";
        }
    }
    private static int bfs(int[][] grid,int row,int col, boolean[][] visited,int m,int n){
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(new Node(row,col));
        visited[row][col]=true;
        int ans=0;
    
        while(queue.isEmpty()==false){
            
            Node node=queue.poll();
            int r=node.getRow();
            int c=node.getCol();
            ans+=grid[r][c];
            int diff[][]={{0,1},{1,0},{-1,0},{0,-1}};
            for(int i=0;i<4;i++){
                int nRow=r+diff[i][0];
                int nCol=c+diff[i][1];
                if(nRow>=0&&nRow<m&&nCol>=0&&nCol<n&&visited[nRow][nCol]==false&&grid[nRow][nCol]>0){
                    queue.add(new Node(nRow,nCol));
                    visited[nRow][nCol]=true;
                }
            }
        }
        return ans;
     }
    public int findMaxFish(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false&&grid[i][j]>0){
                    res=Math.max(res,bfs(grid,i,j,visited,m,n));
                }
            }
        }
        return res;
    }
}