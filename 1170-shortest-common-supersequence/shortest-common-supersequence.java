class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length(),n=str2.length();
        int[][] cache=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    cache[i][j]=i+j;
                }
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    cache[i][j]=1+cache[i-1][j-1];
                }
                else{
                    cache[i][j]=1+Math.min(cache[i-1][j],cache[i][j-1]);
                }
            }
        }
        StringBuilder res=new StringBuilder();
        int i=m,j=n;
        while(i>0&&j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                res.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(cache[i-1][j]<cache[i][j-1]){
                res.append(str1.charAt(i-1));
                i--;
            }else{
                res.append(str2.charAt(j-1));
                j--;
            }
        }
        while(j>0){
            res.append(str2.charAt(j-1));
            j--;
        }
        while(i>0){
            res.append(str1.charAt(i-1));
            i--;
        }
        return res.reverse().toString();

       

    }
}