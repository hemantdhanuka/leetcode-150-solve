import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Q0637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        List<TreeNode> firstLevel = new ArrayList<>();
        firstLevel.add(root);

        while(firstLevel.size() !=0 ){
            double sum = 0;
            List<TreeNode> secondLevel = new ArrayList<>();
            for(int i=0;i<firstLevel.size();i++){
                TreeNode node = firstLevel.get(i);
                sum = sum + node.val;

                TreeNode left = node.left;
                TreeNode right = node.right;

                if(left != null){
                    secondLevel.add(left);
                }

                if(right != null){
                    secondLevel.add(right);
                }
            }
            ans.add(sum / firstLevel.size());
            firstLevel = secondLevel;
        }
        return ans;

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
