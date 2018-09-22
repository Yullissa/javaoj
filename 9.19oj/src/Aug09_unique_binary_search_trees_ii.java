import java.util.ArrayList;

public class Aug09_unique_binary_search_trees_ii {

    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; left = null; right = null; }
     * }
     */
    public ArrayList<TreeNode> generateTrees(int n) {
        return bulidTrees(1, n);
    }

    private ArrayList<TreeNode> bulidTrees(int low, int high) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (low > high) {
            res.add(null);
            return res;
        }
        for (int i = low; i <= high; i++) {
            ArrayList<TreeNode> leftTrees = bulidTrees(low, i - 1);
            ArrayList<TreeNode> rightTrees = bulidTrees(i + 1, high);
            for (int j = 0; j < leftTrees.size(); j++)
                for (int k = 0; k < rightTrees.size(); k++) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = leftTrees.get(j);
                    newNode.right = rightTrees.get(k);
                    res.add(newNode);
                }
        }
        return res;
    }
}