public class Aug04_convert_sorted_array_to_binary_search_tree {
    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode sortedArrayToBST(int[] num) {
        TreeNode root = toBst(num, 0, num.length);
        return root;
    }

    private TreeNode toBst(int[] num, int start, int end) {
        if (start >= end) return null;
        int mid = (end + start) / 2;
        TreeNode newNode = new TreeNode(num[mid]);
        newNode.left = toBst(num, start, mid);
        newNode.right = toBst(num, mid + 1, end);
        return newNode;
    }

}
