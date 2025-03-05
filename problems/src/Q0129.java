public class Q0129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root,"");
    }

    public int dfs(TreeNode root, String number){
        int val = root.val;
        number = number + val;

        if(root.left == null && root.right == null){
            return Integer.parseInt(number);
        }

        int sum = 0;
        if(root.left != null) {
            sum += dfs(root.left, number);
        }

        if(root.right != null){
            sum += dfs(root.right, number);
        }

        return sum;
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
