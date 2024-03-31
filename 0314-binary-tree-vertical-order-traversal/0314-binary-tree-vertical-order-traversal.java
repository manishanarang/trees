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
    int min=0,max=0;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Map<Integer, List<Value>> map = new HashMap<>();
        util(root, map, 0, 0);
        
        for(int i = min; i<=max;i++){
            List<Value> values = map.get(i);
            Collections.sort(values, (a,b)-> a.row-b.row);
            List<Integer> li = new ArrayList<>();
            for(Value v : values){
                li.add(v.val);
            }
            result.add(li);
        }
        return result;
    }
    
    public void util(TreeNode root, Map<Integer, List<Value>> map,int row, int hd){
        if(root == null)
            return;
        
        map.computeIfAbsent(hd, key -> new ArrayList<>()).add(new Value(row, root.val));
        util(root.left, map, row+1, hd-1);
        util(root.right, map, row+1, hd+1);
        
        if(min>hd){
            min=hd;
        }
        else if(max<hd){
            max=hd;
        }
    }
    
   public class Value{
        int row;
        int val;
        
        public Value(int row, int val){
            this.row = row;
            this.val = val;
        }
    
    }
    
}