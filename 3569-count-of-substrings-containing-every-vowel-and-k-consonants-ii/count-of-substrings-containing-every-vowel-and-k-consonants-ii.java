class Solution {
    public long countOfSubstrings(String word, int k) {

        Map<Character,Integer> vow=new HashMap<>();
         int[] nextCons = new int[word.length()];
        int lastConsIdx = word.length();
        for (int i = word.length()- 1; i >= 0; i--) {
            nextCons[i] = lastConsIdx;
            char ch=word.charAt(i);
            if (ch!='a'&&ch!='e'&&ch!='i'&&ch!='o'&&ch!='u') {
                lastConsIdx = i;
            }
        }
        

        int i=0,j=0,con=0;
        long count=0;

        while(j<word.length()){
            char ch=word.charAt(j);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                vow.put(ch,vow.getOrDefault(ch,0)+1);
            }
            else{
                con++;
            }
            while(con>k){
                char c=word.charAt(i);
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    if(vow.get(c)==1){
                        vow.remove(c);
                    }
                    else{
                        vow.put(c,vow.get(c)-1);
                    }
                }
                else{
                    con--;
                }
                i++;
            }

            while(i<word.length()&&vow.size()==5&&con==k){
                int idx=nextCons[j];
                count+=idx-j;
                char c=word.charAt(i);
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    if(vow.get(c)==1){
                        vow.remove(c);
                    }
                    else{
                        vow.put(c,vow.get(c)-1);
                    }
                }
                else{
                    con--;
                }
                i++;
            }
            
            j++;
        }
        return count;
        
    }
}