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
    int[] parent = new int[2];
    int[] depth = new int[2];
    int p=0,d=0;
                          
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || (root.left == null && root.right == null))
            return false;
        
        util(root, null, 0, x,y);
        
        return (parent.length == depth.length && parent[0]!=parent[1] && depth[0]==depth[1]);
    }
    
    public void util(TreeNode node, TreeNode par, int height, int x, int y){
        if(node == null){
            return;
        }
        
        if(List.of(x,y).contains(node.val)){
            if(par!=null){
                parent[p++] = par.val;
            }
            depth[d++] = height;
            return;
        }
        
        util(node.left, node, height+1, x,y);
        util(node.right, node, height+1, x,y);
        return;
    }
}