import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Aug06_binary_tree_zigzag_level_order_traversal {

    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int j = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (j % 2 == 0) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }
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
            j++;
            // 不能用j=j++;
        }
        return res;
    }
}
