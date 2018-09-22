public class June31_sum_root_to_leaf_numbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = dfs(root, 0);
//        System.out.println(sum);
        return sum;
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null || root.val < 0 || root.val > 9)
            return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
