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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return List.of();
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levels = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            levels = new ArrayList<>();
            int s = q.size();
            for(int i = 0; i<s;i++){
                TreeNode temp = q.poll();
                
                levels.add(temp.val);
                
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            if(result.size()%2!=0){
                Collections.reverse(levels);
            }
            result.add(levels);
            
        }    
        return result;
    }  
}