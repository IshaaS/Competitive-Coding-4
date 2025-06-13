//http://leetcode.com/problems/balanced-binary-tree/description/

// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//did dfs and for every left subtree and right subtree checked if it is balanced or not
//using recursison

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
class Solution {
    Boolean flag;
    public boolean isBalanced(TreeNode root) {
        this.flag=true;
        int depth=helper(root,1);
        return flag;
    }
    private int helper(TreeNode root, int depth){
        if(root==null) return depth-1;
        int lstDepth = helper(root.left, depth+1);
        int rstDepth = helper(root.right, depth+1);
        if(lstDepth>rstDepth) {if(lstDepth-rstDepth>1) flag=false;}
        else{
            if(lstDepth<rstDepth){
                if(rstDepth-lstDepth>1) flag=false;
            }
        }
        return Math.max(rstDepth, lstDepth);
    }
}
