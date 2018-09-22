
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Aug04_convert_sorted_list_to_binary_search_tree {
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = null;
        while (head != null) {

            root = insert(root, head);
            head = head.next;
        }
        return root;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /*
     * LL：左左对应的情况(左单旋转)。
     *
     * 返回值：旋转后的根节点
     */
    private TreeNode leftLeftRotation(TreeNode k2) {
        TreeNode k1;
        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    /*
     * RR：右右对应的情况(右单旋转)。
     *
     * 返回值：旋转后的根节点
     */
    private TreeNode rightRightRotation(TreeNode k1) {
        TreeNode k2;
        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    /*
     * LR：左右对应的情况(左双旋转)。
     *
     * 返回值：旋转后的根节点
     */
    private TreeNode leftRightRotation(TreeNode k3) {
        k3.left = rightRightRotation(k3.left);
        return leftLeftRotation(k3);
    }

    /*
     * RL：右左对应的情况(右双旋转)。
     *
     * 返回值：旋转后的根节点
     */
    private TreeNode rightLeftRotation(TreeNode k1) {
        k1.right = leftLeftRotation(k1.right);
        return rightRightRotation(k1);
    }

    /*
     * 将结点插入到AVL树中，并返回根节点
     *
     * 参数说明：
     *     tree AVL树的根结点
     *     key 插入的结点的键值
     * 返回值：
     *     根节点
     */
    private TreeNode insert(TreeNode tree, ListNode key) {
        if (tree == null) {
            // 新建节点
            tree = new TreeNode(key.val);
            if (tree == null) {
                return null;
            }
        } else {
            int cmp = key.val - tree.val;

            if (cmp < 0) {    // 应该将key插入到"tree的左子树"的情况
                tree.left = insert(tree.left, key);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.left) - height(tree.right) == 2) {
                    if (key.val - tree.left.val < 0)
                        tree = leftLeftRotation(tree);
                    else
                        tree = leftRightRotation(tree);
                }
            } else if (cmp > 0) {    // 应该将key插入到"tree的右子树"的情况
                tree.right = insert(tree.right, key);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(tree.right) - height(tree.left) == 2) {
                    if (key.val - tree.right.val > 0)
                        tree = rightRightRotation(tree);
                    else
                        tree = rightLeftRotation(tree);
                }
            }
        }
        return tree;
    }

}