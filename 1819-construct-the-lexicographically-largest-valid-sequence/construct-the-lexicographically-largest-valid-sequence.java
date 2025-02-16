class Solution {
    public int[] constructDistancedSequence(int n) {
        int res[]=new int[(2*n)-1];
        Arrays.fill(res,-1);
        solver(n,res,new boolean[n+1],0);
        return res;
    }
    private static boolean solver(int n,int[] res,boolean[] used,int i){
        if(i>=res.length)return true;
        if(res[i]!=-1){
            return solver(n,res,used,i+1);
        }
        for(int num=n;num>0;num--){
            if(used[num]==true)continue;

            used[num]=true;
            res[i]=num;
            if(num==1){
                if( solver(n,res,used,i+1)){
                    return true;
                }
            }else{
                int j=i+num;
                if(j<res.length&&res[j]==-1){
                    res[j]=num;
                    if(solver(n,res,used,i+1)){
                        return true;
                    }
                    res[j]=-1;
                }
            }
            used[num]=false;
            res[i]=-1;

        }
        return false;
    }
}