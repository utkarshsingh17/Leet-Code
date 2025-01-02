class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] res=new int[queries.length];
        int[] ans=new int[words.length];
        int count=0;
        for(int i=0;i<words.length;i++){
            if(isQualified(words[i]))count++;
            ans[i]=count;

        }
        for(int i=0;i<queries.length;i++){
            int[] query=queries[i];
            int start=query[0];
            int end=query[1];
            if(isQualified(words[start])){
                res[i]=ans[end]-ans[start]+1;
            }else{
                res[i]=ans[end]-ans[start];
            }
        }
        return res;
    }
    public static boolean isQualified(String s){
        char start=s.charAt(0);
        char end=s.charAt(s.length()-1);
        if((start=='a'||start=='e'||start=='i'||start=='o'||start=='u')&&(end=='a'||end=='e'||end=='i'||end=='o'||end=='u'))return true;

        return false;
    }
}