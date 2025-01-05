class Solution {
    public long calculateScore(String s) {
        Map<Character,ArrayList<Integer>> map=new HashMap<>();
        long score=0;
        for(int i=0;i<s.length();i++){
             char current = s.charAt(i);

            
            char m1 = (char) ('z' - (current - 'a')); // Single character mirror
            char m2 = (char) ('a' + ('z' - current)); // Alternate mirror log
            if(map.containsKey(m1)){
                
                score=score+(i-map.get(m1).get(map.get(m1).size()-1));
                map.get(m1).remove((map.get(m1).size())-1);
                map.put(m1,map.get(m1));
                if(map.get(m1).size()==0)map.remove(m1);
                
            }else if(map.containsKey(m2)){
              
                score=score+(i-map.get(m2).get(map.get(m2).size()-1));
                map.get(m2).remove(map.get(m2).size()-1);
                map.put(m2,map.get(m2));
                if(map.get(m2).size()==0)map.remove(m2);
            }else{
               ArrayList<Integer>list= map.getOrDefault(s.charAt(i),new ArrayList<>());
               list.add(i);
                map.put(s.charAt(i),list);
            }
        }
       
        return score;
            
    }
}