import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode889ConstructBinaryTreefromPreorderandPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode> s = new ArrayDeque<>();
        s.offer(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; ++i) {
            TreeNode node = new TreeNode(pre[i]);
            while (s.getLast().val == post[j]) {
                // 说明 以s.getLast().val 为根节点的子树已经遍历完毕。 弹出队列
                s.pollLast();
                j++;
            }

            if (s.getLast().left == null) s.getLast().left = node;
            else s.getLast().right = node;
            s.offer(node);
        }
        return s.getFirst();

        //time O(n^2)  space O(n)
//        int[] pre, post;
//        public TreeNode constructFromPrePost(int[] pre, int[] post) {
//            this.pre = pre;
//            this.post = post;
//            return make(0, 0, pre.length);
//        }
//
//        public TreeNode make(int i0, int i1, int N) {
//            if (N == 0) return null;
//            TreeNode root = new TreeNode(pre[i0]);
//            if (N == 1) return root;
//
//            int L = 1;
//            for (; L < N; ++L)
//                if (post[i1 + L-1] == pre[i0 + 1])
//                    break;
//
//            root.left = make(i0+1, i1, L);
//            root.right = make(i0+L+1, i1+L, N-1-L);
//            return root;
//        }
    }
}
