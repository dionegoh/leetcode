

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //inorder traversal -> left, middle, right
 //postorder traversal -> left, right, middle
 //preorder traversal -> middle, left, right

 import java.util.ArrayList;

 class BinaryTreeInorderTraversal {
     public List<Integer> inorderTraversal(TreeNode root) {
 
         if (root == null) {
             return new ArrayList<Integer>();
         }
 
         ArrayList<Integer> leftList = (ArrayList<Integer>)inorderTraversal(root.left);
         ArrayList<Integer> rightList = (ArrayList<Integer>)inorderTraversal(root.right);
         leftList.add(root.val);
         leftList.addAll(rightList);
 
         return leftList;
 
 
     }
 }