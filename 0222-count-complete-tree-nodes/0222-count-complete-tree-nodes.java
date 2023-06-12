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
    public int getLeftHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    public int getRightHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            root = root.right;
            height++;
        }
        return height;
    }
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if(left == right) {
            System.out.println(String.format("Found same height subtree %d at root %d", left, root.val));
            return (int)Math.pow(2, left) - 1;
        } 

        return 1 + helper(root.left) + helper(root.right);
    }
    public int countNodes(TreeNode root) {
        return helper(root);
    }
}