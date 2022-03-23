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

// optimized itterative solution
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int sum = 0;
        while(!st.isEmpty()){
            root = st.pop();
            if(root.val >= low && root.val <= high){
                sum += root.val;
            }
            if(root.val >= low  && root.left != null){
                st.push(root.left);
            }
            if(root.val <= high && root.right != null){
                st.push(root.right);
            }
        }
        return sum;
    }
}

// iterative solution
// class Solution {
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         Stack<TreeNode> st = new Stack<>();
//         int sum = 0;
//         while(!st.isEmpty() || root != null){
//             while(root != null){
//                 st.push(root);
//                 root = root.left;
//             }
//             root = st.pop();
//             if(root.val >= low && root.val <= high){
//                 sum += root.val;
//             }
//             root = root.right;
//         }
//         return sum;
//     }
// }

// // in-order
// class Solution {
//     int sum;
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         if(root == null) return 0;
//         helper(root, low, high);
//         return sum;
//     }
//     // inorder
//     private void helper(TreeNode root, int low, int high){
//         //base
//         if( root == null ) return;
//         // logic
//         if(root.val >= low)
//             helper(root.left,low,high);
//         if(root.val >= low && root.val <=high){
//             sum += root.val;
//         }
//         if(root.val <= high)
//             helper(root.right,low,high);
//     }
// }

// // pre-order
// class Solution {
//     int sum;
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         if(root == null) return 0;
//         helper(root, low, high);
//         return sum;
//     }
//     // preorder
//     private void helper(TreeNode root, int low, int high){
//         //base
//         if( root == null ) return;
//         // logic
//         if(root.val >= low && root.val <=high){
//             sum += root.val;
//         }
//         if(root.val >= low)
//             helper(root.left,low,high);
//         if(root.val <= high)
//             helper(root.right,low,high);
//     }
// }

// // post-order
// class Solution {
//     int sum;
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         if(root == null) return 0;
//         helper(root, low, high);
//         return sum;
//     }
//     // postorder
//     private void helper(TreeNode root, int low, int high){
//         //base
//         if( root == null ) return;
//         // logic
//         if(root.val >= low)
//             helper(root.left,low,high);
//         if(root.val <= high)
//             helper(root.right,low,high);
//         if(root.val >= low && root.val <=high){
//             sum += root.val;
//         }
//     }
// }