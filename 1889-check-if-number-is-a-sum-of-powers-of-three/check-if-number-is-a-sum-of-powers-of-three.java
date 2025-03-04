class Solution {
    public boolean checkPowersOfThree(int n) {
        return solve(0,n);

    }
    private static boolean solve(int power,int n){
        if(n==0)return true;

        if(Math.pow(3,power)>n)return false;

        boolean take=solve(power+1,n-(int)Math.pow(3,power));
        boolean skip=solve(power+1,n);

        return take||skip;
    }
}