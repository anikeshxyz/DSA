/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root){
        if(root == null)return "null,";
        return root.val +"," +serialize(root.left) +serialize(root.right);
    }
    public TreeNode deserialize(String data){
        Queue<String>nodes =new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    private TreeNode buildTree(Queue<String>nodes){
        String val =nodes.poll();
        if (val.equals("null")) return null;
        TreeNode node =new TreeNode(Integer.parseInt(val));
        node.left= buildTree(nodes);
        node.right =buildTree(nodes);
        return node;
 }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));