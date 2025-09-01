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
    public int diameterOfBinaryTree(TreeNode root) {
        int Dim[] = new int [1];
        height(root,Dim);
        return Dim[0];
    }
    private int height (TreeNode node, int []Dim){
        if(node == null){
            return 0;
        }
        int lh = height(node.left,Dim);
        int rh =height(node.right,Dim);
        Dim[0] = Math.max(Dim[0], lh + rh);
        
        return 1+ Math.max(lh,rh);
    }
}