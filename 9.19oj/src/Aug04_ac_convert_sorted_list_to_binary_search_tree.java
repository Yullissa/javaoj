public class Aug04_ac_convert_sorted_list_to_binary_search_tree {
    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail)
            return null;
        // 申请两个指针，fast移动速度是low的两倍
        ListNode fast = head;
        ListNode slow = head;
        //找到中间节点
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        //递归 左 右 两边
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);

        return root;
    }
}