class Solution {
    public int punishmentNumber(int n) {
        int res=0;
        for (int i=1;i<=n;i++){
            if(solver(Integer.toString(i*i),0,0,i)){
                res=res+(i*i);
            }
        }
        return res;
    }

    private static boolean solver(String s,int i,int cursum,int num){
        if(i==s.length()){
            return (cursum==num);
        }
        if(cursum>num)return false;
        boolean possible=false;
        for(int j=i;j<s.length();j++){
                String sub=s.substring(i,j+1);
                int val=Integer.parseInt(sub);
                possible=possible||solver(s,j+1,cursum+val,num);   
        }
        return possible;
    }
}