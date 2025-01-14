class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] arr=new int[n+1];
        int[] C=new int[n];
        for(int i=0;i<n;i++){
            arr[A[i]]++;
            arr[B[i]]++;
            int count=0;
            for(int j=0;j<=n;j++){
                if(arr[j]==2){
                    count++;
                }
            }
            C[i]=count;
        }

        return C;
        
    }
}