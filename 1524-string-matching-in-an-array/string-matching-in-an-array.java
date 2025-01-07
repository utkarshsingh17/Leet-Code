class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> res=new HashSet<>();
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(i!=j){
                    if(words[i].indexOf(words[j])!=-1){
                        res.add(words[j]);
                    }else if(words[j].indexOf(words[i])!=-1){
                        res.add(words[i]);
                    }
                }

            }
        }
        return new ArrayList<>(res);
    }
}