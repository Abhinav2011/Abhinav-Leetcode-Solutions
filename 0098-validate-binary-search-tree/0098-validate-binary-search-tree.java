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
    private boolean performSearch(TreeNode root, long leftMax, long rightMax) {
        if(root == null) {
            return true;
        }
        if(root.val <= leftMax || root.val >= rightMax) {
            return false;
        }

        return performSearch(root.left, leftMax, root.val) && performSearch(root.right, root.val, rightMax);
    }
    public boolean isValidBST(TreeNode root) {
        return performSearch(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

}