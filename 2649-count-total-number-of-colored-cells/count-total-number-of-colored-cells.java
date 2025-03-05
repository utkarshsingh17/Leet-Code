class Solution {
    public long coloredCells(int n) {
        long res=1L;
        for(int i=1;i<=n;i++){
            res+=(4L*(i-1));
        }
        return res;
    }
    
}