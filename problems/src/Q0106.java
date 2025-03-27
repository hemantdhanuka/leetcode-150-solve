public class Q0106 {
    public static void main(String[] args) {
        Q0106 obj = new Q0106();
        TreeNode root = obj.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

        System.out.println(root);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return this.build(0, inorder.length-1, 0, postorder.length-1, inorder, postorder);
    }

    // approach-1
    // search root element every time
    // worst case n^2
    // can we create hashmap ? apporach -2 there
    private TreeNode build(int inOrderL, int inOrderR, int postOrderL, int postOrderR, int[] inOrder, int[] postOrder){
        if(inOrderL > inOrderR){
            return null;
        }


        int rootElement = postOrder[postOrderR];
        // root will be last element from given postOrder traversal.
        TreeNode root = new TreeNode(rootElement);

        // search root value to find left and right in inOrder traversal
        int rootIndex = searchElement(inOrderL, inOrderR, inOrder, rootElement);

        int elementOnLeftCount = rootIndex - inOrderL;

        root.left = this.build(inOrderL,rootIndex-1,postOrderL, postOrderL-1+elementOnLeftCount, inOrder, postOrder);
        root.right = this.build(rootIndex+1, inOrderR, postOrderL + elementOnLeftCount, postOrderR-1, inOrder, postOrder);

        return root;
    }

    public int searchElement(int l, int r, int[] values, int element){
        int ans = -1;
        while(l<=r){
            if(values[l] == element){
                ans = l;
                break;
            }

            l++;
        }

        return ans;
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


