public class Aug06_construct_binary_tree_from_preorder_and_inorder_traversal {
        /**
         * Definition for binary tree
         * public class TreeNode {
         * int val;
         * TreeNode left;
         * TreeNode right;
         * TreeNode(int x) { val = x; }
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (inorder.length != preorder.length) {
                return null;
            }
            if (inorder.length == 0) {
                return null;
            }
            if (inorder.length == 1) {
                return new TreeNode(inorder[0]);
            }
            TreeNode root = buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
            return root;
        }

        private TreeNode buildSubTree(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
            if (endPre < startPre || endIn < startIn) return null;
            TreeNode root = new TreeNode(preorder[startPre]);
            if (endPre == startPre) return root;
            int rootIndex = startIn;
            for (int i = startIn; i <= endIn; i++) {
                if (inorder[i] == root.val) {
                    rootIndex = i;
                    break;
                }
            }
            root.left = buildSubTree(preorder, startPre + 1, startPre + rootIndex - startIn, inorder, startIn, rootIndex - 1);
            root.right = buildSubTree(preorder, startPre + rootIndex - startIn + 1, endPre, inorder, rootIndex + 1, endIn);
            return root;
        }
    }

