
// !  101. Symmetric Tree

public class SymmetricTree {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isMatched(root.left, root.right);
        }

        boolean isMatched(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }

            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return isMatched(left.left, right.right) && isMatched(left.right, right.left);
        }

    }
    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();
        Solution sol = st.new Solution();
        TreeNode root = st.new TreeNode(1);
        root.left = st.new TreeNode(2);
        root.right = st.new TreeNode(2);
        root.left.left = st.new TreeNode(3);
        root.left.right = st.new TreeNode(4);
        root.right.left = st.new TreeNode(4);
        root.right.right = st.new TreeNode(3);

        boolean result = sol.isSymmetric(root);
        System.out.println("Is the tree symmetric? " + result);
    }
}
