class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> res=new ArrayList<>();
        int i=0;
        int j=0;
        int m=nums1.length;
        int n=nums2.length;
        while(i<m&&j<n){
            if(nums1[i][0]<nums2[j][0]){
                res.add(new int[]{nums1[i][0],nums1[i][1]});
                i++;
            }
            else if(nums2[j][0]<nums1[i][0]){
                res.add(new int[]{nums2[j][0],nums2[j][1]});
                j++;
            }
            else if(nums1[i][0]==nums2[j][0]){
                res.add(new int[]{nums1[i][0],nums1[i][1]+nums2[j][1]});
                    i++;
                    j++;
            }
        }
        while(i<m){
            res.add(new int[]{nums1[i][0],nums1[i][1]});
            i++;
        }
        while(j<n){
            res.add(new int[]{nums2[j][0],nums2[j][1]});
            j++;
        }
        
        return res.toArray(new int[res.size()][]);
    }
}