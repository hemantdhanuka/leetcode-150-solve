import java.util.HashMap;
import java.util.Map;

public class Q0106B {
    public static void main(String[] args) {
        Q0106B obj = new Q0106B();
        TreeNode root = obj.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

        System.out.println(root);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }

        return this.build(0, inorder.length-1, 0, postorder.length-1, inorder, postorder, map);
    }

    // approach-2
    // same as approach-1 just keeping map to search root node.
    private TreeNode build(int inOrderL, int inOrderR, int postOrderL, int postOrderR, int[] inOrder, int[] postOrder, Map<Integer, Integer> inorderIndexMap){
        if(inOrderL > inOrderR){
            return null;
        }


        int rootElement = postOrder[postOrderR];
        // root will be last element from given postOrder traversal.
        TreeNode root = new TreeNode(rootElement);

        // search root value to find left and right in inOrder traversal
        int rootIndex = inorderIndexMap.get(rootElement);

        int elementOnLeftCount = rootIndex - inOrderL;

        root.left = this.build(inOrderL,rootIndex-1,postOrderL, postOrderL-1+elementOnLeftCount, inOrder, postOrder, inorderIndexMap);
        root.right = this.build(rootIndex+1, inOrderR, postOrderL + elementOnLeftCount, postOrderR-1, inOrder, postOrder, inorderIndexMap);

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


