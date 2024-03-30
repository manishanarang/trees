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
   List<Integer> result = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null){
            return result;
        }
        result.add(root.val);
        
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
        return result;
    }
    
    public void printLeftBoundary(TreeNode root){
        if(root == null || (root.left==null && root.right == null)){
            return;
        }
        
        result.add(root.val);
        if(root.left != null)printLeftBoundary(root.left);
        else printLeftBoundary(root.right);
        return;
    }
    
    public void printLeaves(TreeNode root){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            result.add(root.val);
        }
        
        printLeaves(root.left);
        printLeaves(root.right);    
        return;
    }
    
    public void printRightBoundary(TreeNode root){
        if(root == null || (root.left==null && root.right == null)){
            return;
        }
        
        if(root.right != null) printRightBoundary(root.right);
        else printRightBoundary(root.left);
        result.add(root.val);
        
        return;
    }
}