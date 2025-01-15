class Solution {
    public int minimizeXor(int num1, int num2) {
        int count=0;
        int n=num2;
        int res=0;
        while(n>0){
            n=n&(n-1);
            count++;
        }

        for(int i=31;i>=0&&count>0;i--){
            if((num1&(1<<i))!=0){
                count--;
                res=res+(1<<i);
            }
        }
        for(int i=0;i<32&&count>0;i++){
            if((num1&(1<<i))==0){
                count--;
                res=res+(1<<i);
            }
        }


        return res;
    }
}