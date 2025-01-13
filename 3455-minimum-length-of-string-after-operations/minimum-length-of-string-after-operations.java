class Solution {
    public int minimumLength(String s) {
        int[] arr=new int[26];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++){
                if(arr[i]!=0&&arr[i]%2==0){
                    arr[i]=2;
                }else if(arr[i]!=0&&arr[i]%2==1){
                    arr[i]=1;
                }
        }

        int len=0;
        for(int i=0;i<26;i++){
            len+=arr[i];
        }
        return len;
    }
}