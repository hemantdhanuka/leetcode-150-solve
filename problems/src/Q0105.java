import java.util.HashMap;
import java.util.Map;

public class Q0105 {
    public static void main(String[] args) {
        Q0105 obj = new Q0105();
        TreeNode root = obj.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});

        System.out.println(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

        return this.build(0, inorder.length-1, 0, preorder.length-1, preorder, map);
    }


    private TreeNode build(int inOrderL, int inOrderR, int preOrderL, int preOrderR, int[] preOrder, Map<Integer, Integer> inorderIndexMap){
        if(inOrderL > inOrderR){
            return null;
        }


        int rootElement = preOrder[preOrderL];
        // root will be last element from given preOrder traversal.
        TreeNode root = new TreeNode(rootElement);

        // search root value to find left and right in inOrder traversal
        int rootIndex = inorderIndexMap.get(rootElement);

        int elementOnLeftCount = rootIndex - inOrderL;

        root.left = this.build(inOrderL,rootIndex-1,preOrderL+1, preOrderL+elementOnLeftCount, preOrder, inorderIndexMap);
        root.right = this.build(rootIndex+1, inOrderR, preOrderL + elementOnLeftCount+1, preOrderR, preOrder, inorderIndexMap);

        return root;
    }


    class TreeNode {
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


// 9,3,15,20,7  -- inorder
// 9,15,7,20,3  -- postOrder
// total element = index - inOrderL


