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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        util(root, 0);
        Collections.reverse(result);
        return result;
    }
    
    public void util(TreeNode root, int level){
        if(root == null){
            return;
        }
        
        if(result.size() == level){
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        
        util(root.left, level+1);
        util(root.right, level+1);         
    }
    
    
}