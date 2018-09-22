public class Aug06_construct_binary_tree_from_inorder_and_postorder_traversal {
    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        if (inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        int postSize = postorder.length;
        TreeNode root = new TreeNode(postorder[postSize - 1]);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == 0) root.left = null;
        else {
            int[] newInorder = new int[rootIndex];
            int[] newPostorder = new int[rootIndex];
            for (int i = 0; i < rootIndex; i++) {
                newInorder[i] = inorder[i];
                newPostorder[i] = postorder[i];
            }
            root.left = buildTree(newInorder, newPostorder);
        }
        if (rootIndex == postSize - 1) root.right = null;
        int len = postSize - 1 - rootIndex;
        int[] newInorder = new int[len];
        int[] newPostorder = new int[len];
        for (int i = rootIndex; i < rootIndex + len; i++) {
            newInorder[i - rootIndex] = inorder[i + 1];
            newPostorder[i - rootIndex] = postorder[i];
        }
        root.right = buildTree(newInorder, newPostorder);
        return root;
    }
}
