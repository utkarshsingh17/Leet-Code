class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int i=0,j=0,count=0;
        while(i<s.length()){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            while(map.size()==3){
                count+=s.length()-i;
                if(map.get(s.charAt(j))==1){
                    map.remove(s.charAt(j));
                }else{
                    map.put(s.charAt(j),map.get(s.charAt(j))-1);
                }
                j++;
            }
            i++;
        }
        return count;

    }
}