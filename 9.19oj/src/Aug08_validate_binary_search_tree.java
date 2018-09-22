public class Aug08_validate_binary_search_tree {
    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        boolean flag1 = isValidBST(root.left);
        boolean flag2 = root.val > preNode.val;
        preNode = root;
        boolean flag3 = isValidBST(root.right);
        return flag1 && flag2 && flag3;
    }
}