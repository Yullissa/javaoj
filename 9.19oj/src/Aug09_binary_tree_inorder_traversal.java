import java.util.ArrayList;
import java.util.Stack;

public class Aug09_binary_tree_inorder_traversal {
    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
        return;
    }
}
//非递归版本
//public class Solution {
//    public ArrayList<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        if (root == null) return res;
//        Stack<TreeNode> s = new Stack<>();
//        TreeNode p = root;
//        while (!s.empty() || p != null) {
//            while (p != null) {
//                s.push(p);
//                p = p.left;
//            }
//            if (!s.empty()) {
//                p = s.pop();
//                res.add(p.val);
//                p = p.right;
//            }
//        }
//        return res;
//    }
//}
