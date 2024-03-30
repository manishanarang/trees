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
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> levelNodes = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        for(int level = height(root); level>0; level--){
            levelNodes = new ArrayList<>();
            util(root, 1, level);
            result.add(levelNodes);
        }
        return result;
    }
    
    public void util(TreeNode root, int i, int level){
        if(root == null){
            return;
        }
        
        util(root.left, i+1, level);
        util(root.right, i+1, level);
        
        if(i == level){
            levelNodes.add(root.val);        
        }
        
    }
    
    int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        
        return 1 + Math.max(l,r);
    }
    
}