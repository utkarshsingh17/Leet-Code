class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res=new ArrayList<>();
        int freq_map[]=new int[26];
        for(String word:words2){
            int[] temp=count(word);
            for(int i=0;i<26;i++){
                freq_map[i]=Math.max(freq_map[i],temp[i]);
            }
        }

        for(String word:words1){
            int[] temp=count(word);
            boolean flag=true;
            for(int i=0;i<26;i++){
                if(temp[i]<freq_map[i]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                res.add(word);
            }
        }
        return res;
        

    }
    public static int[] count(String s){
        int[] freq=new int[26];
        char[] ch=s.toCharArray();
        for(char c:ch){
            freq[c-'a']++;
        }
        return freq;
    }
}