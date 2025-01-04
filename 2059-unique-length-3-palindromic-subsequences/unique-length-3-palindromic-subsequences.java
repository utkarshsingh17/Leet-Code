class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> set=new HashSet<>();
        Set<String> res=new HashSet<>();
        for(char c:s.toCharArray()){
            set.add(c);
        }
        Iterator<Character> itr=set.iterator();
        while(itr.hasNext()){
            Character ch=(Character)itr.next();
            solver(res,s,s.indexOf(ch),s.lastIndexOf(ch));
        }
        return res.size();  
    }
    public static Set<String> solver(Set<String> set,String s,int start,int end){
        for(int i=start+1;i<end;i++){
            set.add(s.charAt(start)+""+s.charAt(i)+""+s.charAt(end));
        }
        return set;
    }
}