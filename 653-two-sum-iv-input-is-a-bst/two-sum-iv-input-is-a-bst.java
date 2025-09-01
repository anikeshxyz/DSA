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
    public boolean findTarget(TreeNode root, int k) {
        if ( root  == null)return false;

         BSTI left = new BSTI(root, false);
         BSTI right = new BSTI(root,true);

         int i = left.next();
         int j = right.next();

         while (i < j){
            int sum = i + j;
             if(sum == k) return true;
             else if ( sum<k) i =left.next();
             else j =right.next();
             
         }
         return false;
    }
    class BSTI{
        private Stack<TreeNode> stack =new Stack<>();
        private boolean reverse ;
         public BSTI(TreeNode root, boolean isReverse) {
            reverse = isReverse;
         pushAll(root);
    }
  public int next() {
            TreeNode node = stack.pop();
            if (!reverse) pushAll(node.right);
            else pushAll(node.left);
            return node.val;
        }
    private void pushAll (TreeNode node ){
        while(node != null){
            stack.push(node);
            node = reverse ? node . right : node.left;
        }
    }
}
}
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}