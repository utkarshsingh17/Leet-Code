class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set=new HashSet<>();
        for(String num:nums)set.add(num);
        StringBuilder sb=new StringBuilder();
        solver(nums.length,0,set,sb);
        return sb.toString();
    }
    private static boolean solver(int n,int idx,Set<String> set, StringBuilder str){
        if(idx==n && set.contains(str.toString())==false){
            return true;
        }
        if(idx==n)return false;
        for(int i=0;i<=1;i++){
            
            str.append(i);
            if(solver(n,idx+1,set,str))return true;
            str.deleteCharAt(str.length()-1);
            
        }
        return false;
       
        
    }
}