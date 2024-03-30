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
    int count = 0;
    public int goodNodes(TreeNode root){
          return good(root, Integer.MIN_VALUE);

    }
    public int good(TreeNode root, int maxSoFar) {
        if(root == null){
            return 0;
        }
        
       int result = 0;
        if(root.val >= maxSoFar){
            maxSoFar = root.val;
            result = 1;
        }
        return result + good(root.left, maxSoFar) + good(root.right, maxSoFar);
    }
}