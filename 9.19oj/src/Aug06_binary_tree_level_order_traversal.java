import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Aug06_binary_tree_level_order_traversal {
    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            if (list.size() != 0) {
                res.add(list);
            }
            // 不能用j=j++;
        }
        return res;
    }
}
