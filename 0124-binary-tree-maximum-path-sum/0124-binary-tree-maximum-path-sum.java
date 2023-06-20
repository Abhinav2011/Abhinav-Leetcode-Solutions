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
    int maxSum = Integer.MIN_VALUE;
    public int helper(TreeNode root) {
        if(root == null) {
            return -10000;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int sumIncludingRoot = left + right + root.val;
        int sumWithLeft = left + root.val;
        int sumWithRight = right + root.val;
        int firstChoice = Math.max(sumWithLeft, sumWithRight);
        int secondChoice = Math.max(firstChoice, root.val);
        int thirdChoice = Math.max(left, right);
        maxSum = Math.max(maxSum,Math.max(Math.max(firstChoice, secondChoice), Math.max(thirdChoice, sumIncludingRoot)));
        return Math.max(firstChoice, secondChoice);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int x = helper(root);
        return maxSum;
    }
}