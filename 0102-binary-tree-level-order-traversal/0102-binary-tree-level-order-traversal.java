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
    
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null){
            return List.of();
        }
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> levelNodes = new ArrayList<>();
            int q = queue.size();
            
            for(int i = 0; i<q;i++){
                TreeNode temp = queue.poll();
                levelNodes.add(temp.val);
                    
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
            result.add(levelNodes);
        }        
        return result;
    }
}