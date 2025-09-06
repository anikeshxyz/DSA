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
import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair<TreeNode,Long>> queue =new LinkedList<>();
        queue.offer(new Pair<>(root, 0L));

        while (!queue.isEmpty()) {
            int size =queue.size();
            long minIndex =queue.peek().getValue();
            long first = 0,last = 0;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Long> current = queue.poll();
                TreeNode node = current.getKey();
                long index = current.getValue() - minIndex; 
                if (i ==0) first = index;
                if (i == size-1) last = index;
                if (node.left != null)
                    queue.offer(new Pair<>(node.left,2 * index + 1));
                if (node.right != null)
                    queue.offer(new Pair<>(node.right,2* index +2));
            }
            maxWidth= Math.max(maxWidth,(int)(last - first +1));
        }
        return maxWidth;
    }
}

class Pair<K, V> {
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
}
