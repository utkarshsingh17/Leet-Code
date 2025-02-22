/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        int i[]=new int[1];
        int n=traversal.length();
        char[] ch=traversal.toCharArray();
       TreeNode root= solve(ch,i,0,n);
       return root;
    }
    private TreeNode solve(char[] s,int[] i,int d,int n){
        if(i[0]==n)return null;

        int j=i[0];
        while(j<n&&s[j]=='-'){
            j++;
        }
        int dash=j-i[0];
        if(dash!=d){
            return null;
        }

        i[0]+=dash;
        int num=0;
        while(i[0]<n && s[i[0]]!='-'){
            num=(num*10)+Integer.valueOf(s[i[0]]+"");
            i[0]++;
        }
        TreeNode node=new TreeNode(num);
        node.left=solve(s,i,d+1,n);
        node.right=solve(s,i,d+1,n);
        return node;

    }
}