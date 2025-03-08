class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime=sieveHelper(right);
        int[] res=new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
        int minDiff=Integer.MAX_VALUE;
        List<Integer> list=new ArrayList<>();
       for(int i=left;i<=right;i++){
           if(prime[i]==true){
            list.add(i);
           }
       }
       if(list.size()<2)return new int[]{-1,-1};
       for(int i=1;i<list.size();i++){
        int diff=Math.abs(list.get(i-1)-list.get(i));
        if(diff<minDiff){
            res[0]=list.get(i-1);
            res[1]=list.get(i);
            minDiff=diff;
        }
        else if(diff==minDiff && res[0]>list.get(i-1)){
            res[0]=list.get(i-1);
            res[1]=list.get(i);
        }
       }
       if(res[0]==Integer.MAX_VALUE)return new int[]{-1,-1};
       return res;

      
    }
    private static boolean[] sieveHelper(int n){
       boolean[] prime=new boolean[n+1];
       Arrays.fill(prime,true);
       prime[0]=false;
       prime[1]=false;
       for(int i=2;i<=Math.floor(Math.sqrt(n));i++){
            if(prime[i]==true){
                for(int j=2;i*j<=n;j++){
                    prime[i*j]=false;
                }
            }
       }
       return prime;
    }
}