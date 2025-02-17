class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> res=new HashSet<>();
        solver(tiles,res,new boolean[tiles.length()],"");
        return res.size()-1;
        
    }
    private static void solver(String tiles,Set<String> res,boolean[] used, String str){
        res.add(str);
        for(int i=0;i<tiles.length();i++){
            if(used[i]==false){
            used[i]=true;
            str=str+tiles.charAt(i);
            solver(tiles,res,used,str);
            used[i]=false;
            str=str.substring(0,str.length()-1);
            }

        }
    }

}