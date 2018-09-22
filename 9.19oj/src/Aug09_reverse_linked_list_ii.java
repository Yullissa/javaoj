public class Aug09_reverse_linked_list_ii {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode virHead = new ListNode(0);
        virHead.next = head;
        ListNode fast = virHead;
        ListNode fastNext = virHead;
        ListNode slowPre = virHead;
        for (int i = 0; i <= n - m; i++)
            fast = fast.next;
        for (int i = 0; i < m - 1; i++) {
            fast = fast.next;
            slowPre = slowPre.next;
        }
        fastNext = fast.next;
        ListNode left = slowPre.next;
        ListNode mid = null;
        if (left != null)
            mid = left.next;
        ListNode right = null;
        if (mid != null) right = mid.next;
        left.next = null;
        while (mid != null && mid != fastNext) {
            mid.next = left;
            left = mid;
            mid = right;
            if (right != null) {
                right = right.next;
            }
        }

        slowPre.next.next = fastNext;
        slowPre.next = fast;
        return virHead.next;
    }
}
