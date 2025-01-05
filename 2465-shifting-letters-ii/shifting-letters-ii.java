class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] charArray=s.toCharArray();
        int cache[] =new int[s.length()];
        for(int[] shift:shifts){
            if(shift[2]==1){
                cache[shift[0]]++;
                if(shift[1]+1<s.length()){
                    cache[shift[1]+1]--;
                }
            }
                else{
                    cache[shift[0]]--;
                    if(shift[1]+1<s.length()){
                        cache[shift[1]+1]++;
                    }
                }
            
        }
        int totalshifts=0;
        for(int i=0;i<s.length();i++){
            totalshifts=(totalshifts+cache[i])%26;
            if(totalshifts<0)totalshifts=totalshifts+26;
            charArray[i]=(char)('a'+(((charArray[i]-'a')+totalshifts)%26));

        }
        return new String(charArray);
    }
}