class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                
                if(isPrefixAndSuffix(words[j],words[i]))count++;
            }
        }
        return count;
    }
    public static boolean isPrefixAndSuffix(String a, String b){
        int idx1=a.indexOf(b);
        int idx2=a.lastIndexOf(b);
        if(idx1!=-1 && idx2!=-1 && idx1==0 &&idx2==a.length()-b.length()){
            return true;
        }
        return false;
    }
}