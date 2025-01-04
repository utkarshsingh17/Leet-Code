class Solution {
    public boolean hasMatch(String s, String p) {
        
        if(p.charAt(p.length()-1)=='*'){
            p=p+" ";
            s=s+" ";
            }
        if(p.charAt(0)=='*'){
            p=" "+p;
            s=" "+s;
            }
        String str[]=p.split("\\*");
        
        int leftIndex=-1;
        int rightIndex=-1;
    
         leftIndex=s.indexOf(str[0]);
        if(leftIndex==-1)return false;
        
        rightIndex=s.indexOf(str[1],leftIndex+str[0].length());
        System.out.println(s+"::"+rightIndex);
        if(rightIndex<leftIndex+str[0].length())return false;
        if(rightIndex==-1) return false;
        
         return true;

    }
}