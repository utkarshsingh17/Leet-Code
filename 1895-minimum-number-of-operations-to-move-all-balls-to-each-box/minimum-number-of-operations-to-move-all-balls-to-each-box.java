class Solution {
    public int[] minOperations(String boxes) {
        
        int right_sum=0;
        int left_sum=0;
        int right_ones=0;
        int left_ones=0;
        int[] res=new int[boxes.length()];
        for(int i=0;i<boxes.length();i++){
            if(boxes.charAt(i)=='1'){
                right_sum+=i;
                right_ones+=1;
            }
        }

        for(int i=0;i<boxes.length();i++){
            
            res[i]=left_sum+right_sum;
            if(boxes.charAt(i)=='1'){
                left_ones+=1;
                right_ones-=1;
            }
            left_sum+=left_ones;
            right_sum-=right_ones;
        }
        return res;


        
    }
}