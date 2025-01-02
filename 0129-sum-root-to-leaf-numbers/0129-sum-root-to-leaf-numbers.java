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
    int totalValue = 0;
    public void dfs(TreeNode node, StringBuilder value) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            value.append(String.valueOf(node.val));
            totalValue += Integer.parseInt(value.toString());
            System.out.println(totalValue);
            value.deleteCharAt(value.length() - 1);
        }
        value.append(String.valueOf(node.val));
        dfs(node.left, value);
        dfs(node.right, value);
        value.deleteCharAt(value.length() - 1);
    }
    public int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder());
        return totalValue;
    }
}