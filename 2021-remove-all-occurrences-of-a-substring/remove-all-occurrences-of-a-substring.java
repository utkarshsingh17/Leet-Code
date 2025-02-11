class Solution {
    public String removeOccurrences(String s, String part) {
        String res="";
        for(int i=0;i<s.length();i++){
            
            if(res.indexOf(part)!=-1){

                System.out.println(res);
                res=res.substring(0,res.indexOf(part))+res.substring(res.indexOf(part)+part.length(),res.length());
                System.out.println(res);
            }
            
                res=res+s.charAt(i);
            
            
        }
        if(res.indexOf(part)!=-1){
            res=res.substring(0,res.indexOf(part))+res.substring(res.indexOf(part)+part.length(),res.length());
        }
        return res;
    }
}