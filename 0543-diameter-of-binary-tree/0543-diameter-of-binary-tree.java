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
     int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return maxD;
    }
    public int diameter(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = diameter(root.left);
        int r = diameter(root.right);

        this.maxD = Math.max(this.maxD, l+r);
        return Math.max(l,r) + 1;
    }

}