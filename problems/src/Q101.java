public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 == null || node2 == null){
            return false;
        }

        if(node1.val != node2.val){
            return false;
        }

        return isEqual(node1.left, node2.right) && isEqual(node1.right, node2.left);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
