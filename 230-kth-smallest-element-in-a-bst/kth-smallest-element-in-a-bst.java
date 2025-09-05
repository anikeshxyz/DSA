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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        traverse(root, inorder);
        return inorder.get(k - 1);
    }

    private void traverse(TreeNode node, List<Integer> inorder) {
        if (node == null) return;
        traverse(node.left, inorder);
        inorder.add(node.val);
        traverse(node.right, inorder);
    }
}
