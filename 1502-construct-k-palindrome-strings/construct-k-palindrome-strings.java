class Solution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length())return false;
        Map<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int e_count=0;
        int o_count=0;
        for(int v:map.values()){
            if(v%2==0) e_count++;
            else o_count++;
        }
        if(o_count>k)return false;

        return true;

    }
}