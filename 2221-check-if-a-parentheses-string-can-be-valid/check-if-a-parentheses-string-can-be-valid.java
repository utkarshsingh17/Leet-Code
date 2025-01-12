class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2==1)return false;
        int o_count=0;
        int c_count=0;
        int w_count=0;

        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0')w_count++;
            else if(s.charAt(i)=='(')o_count++;
            else c_count++;

            if(w_count<c_count-o_count) return false;
        }

        o_count=0;
        c_count=0;
        w_count=0;

        for(int i=s.length()-1;i>=0;i--){
            if(locked.charAt(i)=='0')w_count++;
            else if(s.charAt(i)=='(')o_count++;
            else c_count++;

            if(w_count<o_count-c_count) return false;
        }

        return true;



        
    }
}