class Solution {
    public int longestPalindromicSubsequence(String s, int k) {
        int[][][] cache=new int[s.length()][s.length()][k+1];
        for(int[][]c:cache){
            for(int[] r:c){
                Arrays.fill(r,-1);
            }
        }
        return lps(s.toCharArray(),0,s.length()-1,k,cache);
    }
    private int lps(char[]s,int i,int j,int k,int[][][] cache){
        if(i>j)return 0;
        if(i==j)return 1;
        if(cache[i][j][k]!=-1)return cache[i][j][k];
        if(s[i]==s[j]){
            cache[i][j][k]= 2+lps(s,i+1,j-1,k,cache);
            return cache[i][j][k];
        }
        int nochange=Math.max(lps(s,i+1,j,k,cache),lps(s,i,j-1,k,cache));
        int change=0;
        int cost=Math.min(Math.abs(s[i]-s[j]),26-Math.abs(s[i]-s[j]));
        if(k>=cost){
                change= 2+lps(s,i+1,j-1,k-cost,cache);
        }
        return cache[i][j][k]=Math.max(change,nochange);
    }
    private boolean helper(char a,char b,int k){
        //int diff=Math.abs(a-b);
        return Math.abs(a-b)<=k;
    }
    private char nexthelper(char c){
        return c=='z'?'a':(char)(c+1);
    }
    private char prevhelper(char c){
        return c=='a'?'z':(char)(c-1);
    }
}