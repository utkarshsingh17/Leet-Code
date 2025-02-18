class Solution {
    public String smallestNumber(String pattern) {
        List<Integer> res=new ArrayList<>();
        boolean used[]=new boolean[10];
        solver(pattern,0,res,used);
        return res.stream().map(String::valueOf).collect(Collectors.joining());
        
    }
    private static boolean solver(String pattern,int idx,List<Integer> res,boolean[] used){
        if(res.size()==pattern.length()+1){
            return true;
        }
        if(idx<0)return false;
        for(int i=1;i<=9;i++){
            if(used[i]==true)continue;
            if(res.isEmpty()||(pattern.charAt(idx-1)=='I'&&res.get(idx-1)<i)||(pattern.charAt(idx-1)=='D'&&res.get(idx-1)>i)){
                res.add(i);
                used[i]=true;
                if(solver(pattern,idx+1,res,used))return true;
                used[i]=false;
                res.remove(res.size()-1);
            }
            
        }
        return false;
    }
}