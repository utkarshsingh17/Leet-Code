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
class FindElements {
    TreeNode recoverTree=new TreeNode(0);
    public FindElements(TreeNode root) {
        helper(root,recoverTree);
        //System.out.println(recoverTree.right.val);
    }
    
    public boolean find(int target) {
        return solver(recoverTree,target);
        
    }
    private void helper(TreeNode root,TreeNode recoverTree){
        if(root==null) return;
        if(root.left!=null){
            TreeNode node=new TreeNode((recoverTree.val*2)+1);
            recoverTree.left=node;
            helper(root.left,recoverTree.left);
        }
        if(root.right!=null){
            TreeNode node=new TreeNode((recoverTree.val*2)+2);
            recoverTree.right=node;
            helper(root.right,recoverTree.right);
        }
    }
    private boolean solver(TreeNode root,int target){
        if(root==null)return false;
        if(root.val==target){
            return true;
        }
        return solver(root.left,target)||solver(root.right,target);
        
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */