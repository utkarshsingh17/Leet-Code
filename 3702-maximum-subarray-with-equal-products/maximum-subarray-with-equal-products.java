class Solution {
    public static int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    public static int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
    public int maxLength(int[] nums) {
        int n=nums.length;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            int cPro=nums[i];
            int cGcd=nums[i];
            int cLcm=nums[i];
            for(int j=i+1;j<n;j++){
                cPro=cPro*nums[j];
                cGcd=gcd(cGcd,nums[j]);
                cLcm=lcm(cLcm,nums[j]);
                if(cPro==cGcd*cLcm){
                    res=Math.max(res,(j-i)+1);
                }
            }
            
        } 
        return res;
    }
}