import java.util.ArrayList;

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Aug02_path_sum_ii {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int curSum = 0;
        ArrayList<Integer> curPath = new ArrayList<>();
        dfs(root, curSum, sum, curPath, res);
        return res;
    }

    private void dfs(TreeNode root, int curSum, int sum, ArrayList<Integer> curPath, ArrayList<ArrayList<Integer>> res) {
        if (root == null) return;
        curSum = curSum + root.val;
        if (curSum == sum && root.right == null && root.left == null) {
            curPath.add(root.val);
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer item : curPath) {
                temp.add(item);
            }
            res.add(temp);
            curPath.remove(curPath.size() - 1);
            return;
        }
        curPath.add(root.val);
        dfs(root.left, curSum, sum, curPath, res);
        curPath.remove(curPath.size() - 1);
        curPath.add(root.val);
        dfs(root.right, curSum, sum, curPath, res);
        curPath.remove(curPath.size() - 1);
    }
}