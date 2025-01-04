class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> set=new HashSet<>();
        int result=0;
        for(char c:s.toCharArray()){
            set.add(c);
        }
        Iterator<Character> itr=set.iterator();
        int[][] preCompute=new int[26][2];
        while(itr.hasNext()){
            Character ch=(Character)itr.next();
            preCompute[ch-'a'][0]=s.indexOf(ch);
            preCompute[ch-'a'][1]=s.lastIndexOf(ch);
        }
        itr=set.iterator();
        while(itr.hasNext()){
            Character ch=(Character)itr.next();
            int left=preCompute[ch-'a'][0];
            int right=preCompute[ch-'a'][1];
            Set<Character> res=new HashSet<>();
            for(int i=left+1;i<=right-1;i++){
                res.add(s.charAt(i));
            }
            result+=res.size();
        }
        return result;  
    }
}