class Solution {
    public int maxArea(int[] height) {

        int left=0;
        int right=height.length-1;
        int l=0,b=0,area=Integer.MIN_VALUE;
        while(left<right){
            l =Math.min(height[left],height[right]);
            b=right-left;
            area=Math.max(area,l*b);
            if(height[left]<=height[right]) left++;
            else right--;
            
        }
        return area;
        
    }
}