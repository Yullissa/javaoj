/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Aug04_balanced_binary_tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(level(root.left) - level(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        else
            return false;
    }

    private int level(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(level(root.left), level(root.right));
    }
}