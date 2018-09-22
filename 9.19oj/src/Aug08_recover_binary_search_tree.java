public class Aug08_recover_binary_search_tree {
    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    TreeNode curMax = null;
    TreeNode curMin = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = curMax.val;
        curMax.val = curMin.val;
        curMin.val = temp;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (curMax == null && root.val <= preNode.val)
            curMax = preNode;
        if (curMax != null && root.val <= preNode.val)
            curMin = root;
        preNode = root;
        dfs(root.right);
    }
}