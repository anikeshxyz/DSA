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
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){
            return result;
        }
        inorder(root,new StringBuilder());
        return result;
    }
    public void inorder(TreeNode root,StringBuilder sb){
        if(root==null){
            return;
        }
        if(sb.length()>0){
            sb.append("->");
        }
        sb.append(Integer.toString(root.val));
        if(root.left==null && root.right==null){
            result.add(sb.toString());
        }
             inorder(root.left, new StringBuilder(sb));
             inorder(root.right, new StringBuilder(sb));
  
    }
}