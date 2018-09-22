public class Aug02_populating_next_right_pointers_in_each_node_ii {
    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     * int val;
     * TreeLinkNode left, right, next;
     * TreeLinkNode(int x) { val = x; }
     * }
     */
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode prev = new TreeLinkNode(-1);
            TreeLinkNode dump = null;
            for (TreeLinkNode p = root; p != null; p = p.next) {
                if (p.left != null) {
                    prev.next = p.left;
                    prev = p.left;
                    if (dump == null) dump = p.left;
                }
                if (p.right != null) {
                    prev.next = p.right;
                    prev = p.right;
                    if (dump == null) dump = p.right;
                }
            }
            root = dump;
        }
        return;
    }
}
