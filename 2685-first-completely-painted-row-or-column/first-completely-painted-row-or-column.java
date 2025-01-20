class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int table[][]=new int[arr.length+1][4];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                table[mat[i][j]][0]=mat[i][j];
                table[mat[i][j]][1]=i;
                table[mat[i][j]][2]=j;
            }
        }
        int[] row=new int[m];
        int[] col=new int[n];
        for(int i=0;i<arr.length;i++){
                table[arr[i]][3]=1;
                row[table[arr[i]][1]]++;
                col[table[arr[i]][2]]++;
                if(row[table[arr[i]][1]]==n||col[table[arr[i]][2]]==m)return i;
        }
        return -1;

    }
    public static boolean checkRow(int mat[][],int table[][],int row,int n){
        int count=0;
        for(int i=0;i<n;i++){
            if(table[mat[row][i]][3]==1)count++;
        }
        if(count==n)return true;
        return false;
    }
    public static boolean checkCol(int mat[][],int table[][],int col,int m){
         int count=0;
        for(int i=0;i<m;i++){
            if(table[mat[i][col]][3]==1)count++;
        }
        if(count==m)return true;
        return false;
    }
}