import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Aug06_tree_level_order_traversal_ii {


    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
//        ArrayList<TreeNode> curTreeNodes = new ArrayList<>();
//        学着使用Queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
//            ArrayList<TreeNode> nextTreeNodes = new ArrayList<>();
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
                res.add(0, list);
            }
        }
        return res;
    }
}
