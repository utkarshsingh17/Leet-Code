class Solution {
    public int maxScore(String s) {
         int sLeft[]=new int[s.length()];
        int sRight[]=new int[s.length()];
        int left=0,right=s.length()-1;
        int leftScore=0,rightScore=0,score=Integer.MIN_VALUE;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='0'){
                leftScore++;
            }
            sLeft[i]=leftScore;
        }
        sLeft[s.length()-1]=leftScore;
        for(int i=s.length()-1;i>0;i--){
            if(s.charAt(i)=='1'){
                rightScore++;

            }
            sRight[i]=rightScore;
        }
        sRight[0]=rightScore;
        for(int i=0;i<s.length();i++){
            score=Math.max(score,sLeft[i]+sRight[i]);
        }
        return score;
    }
}