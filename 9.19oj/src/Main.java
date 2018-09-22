import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class Main {
    public int[][] printTree(TreeNode root) {
        // write code here
        TreeNode last = root;
        TreeNode nlast = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int[][] ans = new int[500][500];
        int curRow = 0;
        int curCol = 0;
        while (queue.size() != 0) {
//            System.out.println();
//            ans[curRow][curCol] = queue.peek().val;
            ans[curRow][curCol] = queue.peek().val;
            curCol++;
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
                nlast = queue.peek().left;
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
                nlast = queue.peek().right;
            }
            if (queue.peek() == last) {
                last = nlast;
                curRow++;
                curCol = 0;
            }
            queue.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        root0.left = root1;
        root0.right = root2;
        root2.right = root3;
        new Main().printTree(root0);
    }
}