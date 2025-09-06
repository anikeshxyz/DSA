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
     private Map<Integer, Long> firstIndexMap = new HashMap<>();
    private int maxWidth = 0;
    public int widthOfBinaryTree(TreeNode root) {
      dfs(root, 0, 0L);
        return maxWidth;
    }
    private void dfs(TreeNode node,int depth, long index) {
        if (node == null) return;
        firstIndexMap.putIfAbsent(depth,index);
        int width = (int)(index -firstIndexMap.get(depth) + 1);
        maxWidth = Math.max(maxWidth,  width);
        dfs(node.left, depth + 1,2*index + 1);
        dfs(node.right,depth+ 1,2* index + 2);

    }
}